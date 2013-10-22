package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.services.GenericService;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class GenericServiceImpl
* @date 22/10/2013
*
 */
public abstract class GenericServiceImpl<T, PK extends Serializable> implements
		GenericService<T, PK> {

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * persistentClass
	 */
	private Class<T> persistentClass;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public abstract GenericRepository<T, PK> getDao();

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#getEntityClass()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getEntityClass() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return persistentClass;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findById(java.io.Serializable)
	 */
	@Override
	public T findById(PK id) {
		return getDao().findById(id);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByExample(java.lang.Object)
	 */
	@Override
	public List<T> findByExample(T exampleInstance) {
		return getDao().findByExample(exampleInstance);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<T> findByNamedQuery(String queryName, Object... params) {
		return getDao().findByNamedQuery(queryName, params);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByNamedQueryAndNamedParams(java.lang.String, java.util.Map)
	 */
	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName,
			Map<String, ? extends Object> params) {
		return getDao().findByNamedQueryAndNamedParams(queryName, params);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#countAll()
	 */
	@Override
	public int countAll() {
		return getDao().countAll();
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#countByExample(java.lang.Object)
	 */
	@Override
	public int countByExample(T exampleInstance) {
		return getDao().countByExample(exampleInstance);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#save(java.lang.Object)
	 */
	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

}
