CREATE DATABASE  IF NOT EXISTS `accounting`;
USE `accounting`;

--
-- Table structure for table `expense_type`
--
DROP TABLE IF EXISTS `expense_types`;
CREATE TABLE `expense_types` (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
  `default_value` BIT(1) NULL DEFAULT NULL,
  `description` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Table structure for table `expense_period`
--
DROP TABLE IF EXISTS `expense_periods`;
CREATE TABLE `expense_periods` (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
  `default_value` BIT(1) NULL DEFAULT NULL,
  `description` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Table structure for table `companies`
--
DROP TABLE IF EXISTS `companies`;
CREATE TABLE `companies` (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL DEFAULT NULL,
	`created_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_at` DATETIME NULL DEFAULT NULL,
	`address` VARCHAR(255) NOT NULL,
	`cif` VARCHAR(255) NOT NULL,
	`company_name` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`telephone` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Table structure for table `sales_invoices`
--
DROP TABLE IF EXISTS `sales_invoices`;
CREATE TABLE `sales_invoices` (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL DEFAULT NULL,
	`created_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_at` DATETIME NULL DEFAULT NULL,
	`date` DATE NOT NULL,
	`invoice_number` VARCHAR(255) NOT NULL,
	`taxable_base` INT(11) NOT NULL,
	`total_invoice` INT(11) NOT NULL,
	`vat_amount` INT(11) NOT NULL,
	`vat_percentage` INT(11) NOT NULL,
	`company_id` BIGINT(20) unsigned NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `sales_invoices_company_index` (`company_id`),
  CONSTRAINT `sales_invoice_company_constraint` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `purchase_invoices`
--
DROP TABLE IF EXISTS `purchase_invoices`;
CREATE TABLE `purchase_invoices` (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL DEFAULT NULL,
	`created_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_at` DATETIME NULL DEFAULT NULL,
	`date` DATE NOT NULL,
	`invoice_number` VARCHAR(255) NOT NULL,
	`taxable_base` INT(11) NOT NULL,
	`total_invoice` INT(11) NOT NULL,
	`vat_amount` INT(11) NOT NULL,
	`vat_percentage` INT(11) NOT NULL,
	`company_id` BIGINT(20) unsigned NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `purchase_invoices_company_index` (`company_id`),
  CONSTRAINT `purchase_invoices_company_constraint` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `purchase_invoice_class_data`
--
DROP TABLE IF EXISTS `purchase_invoice_class_data`;
CREATE TABLE `purchase_invoice_class_data` (
  `invoice_id` BIGINT(20) unsigned NOT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
	`created_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_by_user` VARCHAR(255) NULL DEFAULT NULL,
	`updated_at` DATETIME NULL DEFAULT NULL,
  `expense_period_id` BIGINT(20) unsigned NULL DEFAULT NULL,
	`expense_type_id` BIGINT(20) unsigned NULL DEFAULT NULL,
	`vat_applicable` BIT(1) NULL DEFAULT NULL,
	`vat_percentage_applicable` DOUBLE NULL DEFAULT NULL,
  `amortization_policy` VARCHAR(255) NULL DEFAULT NULL,
	`annual_amortization_percentage` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`invoice_id`),
	INDEX `class_data_period_index` (`expense_period_id`),
	INDEX `class_data_type_index` (`expense_type_id`),
	CONSTRAINT `class_data_invoice_constraint` FOREIGN KEY (`invoice_id`) REFERENCES `purchase_invoices` (`id`),
	CONSTRAINT `class_data_period_constraint` FOREIGN KEY (`expense_period_id`) REFERENCES `expense_periods` (`id`),
	CONSTRAINT `class_data_type_constraint` FOREIGN KEY (`expense_type_id`) REFERENCES `expense_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;