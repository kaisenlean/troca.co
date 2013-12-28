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
public abstract class GenericServiceImpl<TYPE, PK extends Serializable> implements
		GenericService<TYPE, PK> {

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * persistentClass
	 */
	private Class<TYPE> persistentClass;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public abstract GenericRepository<TYPE, PK> getDao();

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#getEntityClass()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Class<TYPE> getEntityClass() {
		this.persistentClass = (Class<TYPE>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return persistentClass;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findById(java.io.Serializable)
	 */
	@Override
	public TYPE findById(PK id) {
		return getDao().findById(id);
	}
	
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findById(java.io.Serializable, java.lang.Class)
	 */
	@Override
	public Object findById(PK id, Class<?> clazz) {
		return getDao().findById(id, clazz);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findAll()
	 */
	@Override
	public List<TYPE> findAll() {
		return getDao().findAll();
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByExample(java.lang.Object)
	 */
	@Override
	public List<TYPE> findByExample(TYPE exampleInstance) {
		return getDao().findByExample(exampleInstance);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<TYPE> findByNamedQuery(String queryName, Object... params) {
		return getDao().findByNamedQuery(queryName, params);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#findByNamedQueryAndNamedParams(java.lang.String, java.util.Map)
	 */
	@Override
	public List<TYPE> findByNamedQueryAndNamedParams(String queryName,
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
	public int countByExample(TYPE exampleInstance) {
		return getDao().countByExample(exampleInstance);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#save(java.lang.Object)
	 */
	@Override
	public TYPE save(TYPE entity) {
		return getDao().save(entity);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.GenericRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(TYPE entity) {
		getDao().delete(entity);
	}

}
