package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import co.icesi.troca.repositories.GenericRepository;

/**
 * JPA implementation of the GenericRepository. Note that this implementation
 * also expects Hibernate as JPA implementation. That's because we like the
 * Criteria API.
 * 
 * @author Jurgen Lust
 * @author $LastChangedBy: jlust $
 * 
 * @version $LastChangedRevision: 257 $
 * 
 * @param <T>
 *            The persistent type
 * @param <ID>
 *            The primary key type
 */
@Transactional
@SuppressWarnings("unchecked")
public class GenericJpaRepository<T, ID extends Serializable> implements
		GenericRepository<T, ID> {

	// ~ Instance fields
	// --------------------------------------------------------

	private final Class<T> persistentClass;
	private EntityManager entityManager;

	// ~ Constructors
	// -----------------------------------------------------------

	@SuppressWarnings("unchecked")
	public GenericJpaRepository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericJpaRepository(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	// ~ Methods
	// ----------------------------------------------------------------

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#countAll()
	 */
	@Override
	public int countAll() {
		return countByCriteria();
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#countByExample(java.lang.Object)
	 */
	@Override
	public int countByExample(final T exampleInstance) {
		Session session = getEntityManager().unwrap(Session.class);
		Criteria crit = session.createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());
		crit.add(Example.create(exampleInstance));

		return (Integer) crit.list().get(0);
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#findByExample(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(final T exampleInstance) {

		Session session = getEntityManager().unwrap(Session.class);
		Criteria crit = session.createCriteria(getEntityClass());
		final List<T> result = crit.list();
		return result;
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#findById(java.io.Serializable)
	 */
	@Override
	public T findById(final ID id) {
		final T result = getEntityManager().find(persistentClass, id);
		return result;
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#findByNamedQuery(java.lang.String,
	 *      java.lang.Object[])
	 */
	
	@Override
	public List<T> findByNamedQuery(final String name, Object... params) {
		javax.persistence.Query query = getEntityManager().createNamedQuery(
				name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<T> resultado = (List<T>) query.getResultList();
		return resultado;
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#findByNamedQueryAndNamedParams(java.lang.String,
	 *      java.util.Map)
	 */
	
	@Override
	public List<T> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		javax.persistence.Query query = getEntityManager().createNamedQuery(
				name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<T> resultado = (List<T>) query.getResultList();
		return resultado;
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#getEntityClass()
	 */
	@Override
	public Class<T> getEntityClass() {
		return persistentClass;
	}

	/**
	 * set the JPA entity manager to use.
	 * 
	 * @param entityManager
	 */
	@Required
	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(final Criterion... criterion) {
		return findByCriteria(-1, -1, criterion);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final int firstResult,
			final int maxResults, final Criterion... criterion) {
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		if (firstResult > 0) {
			crit.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			crit.setMaxResults(maxResults);
		}

		final List<T> resultado = crit.list();

		return resultado;
	}

	protected int countByCriteria(Criterion... criterion) {
		Session session = getEntityManager().unwrap(Session.class);
		Criteria crit = session.createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		return (Integer) crit.list().get(0);
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#delete(java.lang.Object)
	 */
	@Override
	
	public void delete(T entity) {
//		Session session = getEntityManager().unwrap(Session.class);
//		session.delete(entity);
		getEntityManager().remove(getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity));
	}

	/**
	 * @see be.bzbit.framework.domain.repository.GenericRepository#save(java.lang.Object)
	 */
	@Override

	public T save(T entity) {
		final T savedEntity = getEntityManager().merge(entity);
		return savedEntity;
	}

	
	
	
}
