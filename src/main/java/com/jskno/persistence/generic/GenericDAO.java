//@formatter:off
/**
 *  $Id: GenericDAO.java 197648 2014-09-19 12:41:38Z velasca $ 
 *       . * .
 *     * RRRR  *    Copyright (c) 2014 OHIM: Office for Harmonization
 *   .   RR  R   .  in the Internal Market (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.persistence.generic;

import org.hibernate.ScrollableResults;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * Generic interface for DAOs, defining the common operations
 *
 * @param <T> the type of the entity
 * @param <I> the type of the entity's id
 */
public interface GenericDAO<T, I extends Serializable> {

	/**
	 * Creates a new entity.
	 *
	 * @param entity the entity to be persisted
	 * @return the persisted entity
	 */
	T create(final T entity);

	/**
	 * Returns the entity with the provided ID.
	 *
	 * @param id the ID of the entity
	 * @return the found entity
	 */
	T read(final I id);

	/**
	 * Updates the provided entity.
	 *
	 * @param entity the entity to be updated
	 * @return the updated entity
	 */
	T update(final T entity);

	/**
	 * Deletes the provided entity.
	 *
	 * @param entity the entity to be deleted
	 */
	void delete(final T entity);

	/**
	 * Deletes the entity with the provided ID.
	 *
	 * @param id the Id of the entity
	 */
	void deleteById(final I id);

	/**
	 * the findall method
	 *
	 * @return
	 */
	Iterable<T> findAll();

	/**
	 * the findall method
	 *
	 * @return
	 */
	Stream<T> findAllStream();

	/**
	 * finds all elements
	 * @return all elements in a scrollable way
	 */
	ScrollableResults findAllScrollable();

	/**
	 * save a list of elements
	 * 
	 * @param it
	 * @return
	 */
	Iterable<T> update(Iterable<T> it);

	/**
	 * @param oldEntity
	 * @param newEntity
	 */
	void deleteAndCreate(T oldEntity, T newEntity);

	/**
	 * Returns the entity class with which the DAO is working.
	 * To be implemented by all the non abstract subclasses.
	 * 
	 * @return the entity class
	 */
	Class<T> getClazz();

	/**
	 * Delete a Iterable of entities
	 * 
	 * @param entities
	 */
	void delete(Iterable<T> entities);

	/**
	 * insert a list of elements
	 * 
	 * @param it list of element to add
	 * @return
	 */
	Iterable<T> create(Iterable<T> it);

}
