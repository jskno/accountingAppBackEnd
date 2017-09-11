//@formatter:off
/**
 * 
 *       . * .
 *     * RRRR  *    Copyright (c) 2015 OHIM: Office for Harmonization
 *   .   RR  R   .  in the Internal Market (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 * 
 * 	Author: SetforIT
 * 	Modification Date: 24-sep-2015 9:00:15
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package com.jskno.persistence.generic.impl;

import com.jskno.persistence.generic.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.stream.Stream;

/**
 * Abstract generic DAO implementing the common operations
 * 
 * @param <T> The type of the entity
 * @param <I> The type of the entity's id
 */
public abstract class AbstractGenericDAOImpl<T, I extends Serializable> implements GenericDAO<T, I> {

	/**
	 * the persistent class
	 */
	protected Class<T> persistentClass;

	/**
	 * Returns the Entity Manager.
	 * To be extended by the database specific Abstract DAOs.
	 * 
	 * @return the entity manager
	 */
	public abstract EntityManager getEntityManager();

	/**
	 * the constructor
	 */
	@SuppressWarnings("unchecked")
	public AbstractGenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Creates a new entity.
	 * 
	 * @param entity the entity to be persisted
	 * @return the persisted entity
	 */
	@Override
	public T create(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	/**
	 * Returns the entity with the provided ID.
	 * 
	 * @param id the ID of the entity
	 * @return the found entity
	 */
	@Override
	public T read(I id) {
		return getEntityManager().find(getClazz(), id);
	}

	/**
	 * Updates the provided entity.
	 * 
	 * @param entity the entity to be updated
	 * @return the updated entity
	 */
	@Override
	public T update(T entity) {
		return getEntityManager().merge(entity);
	}

	/**
	 * Deletes the provided entity.
	 * 
	 * @param entity the entity to be deleted
	 */
	@Override
	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public void delete(Iterable<T> entities) {
		if (entities != null) {
			for (T t : entities) {
				this.delete(t);
			}
		}
	}

	/**
	 * Delete and create entity
	 */
	@Override
	public void deleteAndCreate(T oldEntity, T newEntity) {
		this.delete(oldEntity);
		this.create(newEntity);
		this.getEntityManager().flush();
	}

	/**
	 * Deletes the entity with the provided ID.
	 * 
	 * @param id the ID of the entity
	 */
	@Override
	public void deleteById(I id) {
		T entity = read(id);
		delete(entity);
	}

	/**
	 * find all the elements
	 */
	@Override
	public Iterable<T> findAll() {
		return this.findAllInvocation(null, null);
	}

	/**
	 * find all the elements
	 */
	@Override
	public Stream<T> findAllStream() {

		throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * find all the elements
	 */
	@Override
	public ScrollableResults findAllScrollable() {
		Session session = getEntityManager().unwrap(Session.class);

		Criteria criteria = session.createCriteria(this.persistentClass);

		DiscriminatorValue discriminatorValue = persistentClass.getAnnotation(DiscriminatorValue.class);
		if (discriminatorValue != null) {
			DiscriminatorColumn discriminatorColumn = AnnotationUtils.findAnnotation(persistentClass, DiscriminatorColumn.class);
			//FIXME Pending to use the HibernateMapping to extract the fieldName
//			if (discriminatorColumn != null && discriminatorColumn.name().equals("dossiersubkindcode")) {
//				criteria.add(Restrictions.eq("dossierSubKind", DossierSubType.fromKey(discriminatorValue.value())));
//			}
		}

		ScrollableResults results =	criteria.scroll(ScrollMode.FORWARD_ONLY);

		return results;
	}

	/**
	 * updates a list of elements
	 * 
	 * @param it list of elements to update
	 */
	@Override
	public Iterable<T> update(Iterable<T> it) {
		if (it != null) {
			for (T t : it) {
				this.update(t);
			}
		}
		return it;
	}

	/**
	 * insert a list of elements
	 * 
	 * @param it list of elements to insert
	 */
	@Override
	public Iterable<T> create(Iterable<T> it) {
		if (it != null) {
			for (T t : it) {
				this.create(t);
			}
		}
		return it;
	}

	/**
	 * Method that finds all the records
	 */
	private Iterable<T> findAllInvocation(Integer firstResult, Integer maxResult) {

		CriteriaBuilder cBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> query = cBuilder.createQuery(this.persistentClass);
		Root<T> root = query.from(this.persistentClass);
		query.select(root);

		TypedQuery<T> typedQuery = getEntityManager().createQuery(query);

		if (firstResult != null) {
			typedQuery.setFirstResult(firstResult);
		}
		if (maxResult != null) {
			typedQuery.setMaxResults(maxResult);
		}

		return typedQuery.getResultList();
	}

}
