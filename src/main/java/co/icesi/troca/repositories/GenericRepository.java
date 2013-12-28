package co.icesi.troca.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Generic Repository, providing basic CRUD operations
 * 
 * @author Jurgen Lust
 * @author $LastChangedBy: jlust $
 * 
 * @version $LastChangedRevision: 257 $
 * 
 * @param <TYPE>
 *            the entity type
 * @param <ID>
 *            the primary key type
 */
public interface GenericRepository<TYPE, PK extends Serializable> {
	// ~ Methods
	// ----------------------------------------------------------------

	/**
	 * Get the Class of the entity
	 * 
	 * @return the class
	 */
	Class<TYPE> getEntityClass();

	/**
	 * Find an entity by its primary key
	 * 
	 * @param id
	 *            the primary key
	 * @return the entity
	 */
	TYPE findById(final PK id);
	
	
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 8/12/2013
	* @param id
	* @param clazz
	* @return
	*/
	Object findById(final PK id ,  Class<?>  clazz) ;

	/**
	 * Load all entities
	 * 
	 * @return the list of entities
	 */
	List<TYPE> findAll();

	/**
	 * Find entities based on an example
	 * 
	 * @param exampleInstance
	 *            the example
	 * @return the list of entities
	 */
	List<TYPE> findByExample(final TYPE exampleInstance);

	/**
	 * Find using a named query
	 * 
	 * @param queryName
	 *            the name of the query
	 * @param params
	 *            the query parameters
	 * 
	 * @return the list of entities
	 */
	List<TYPE> findByNamedQuery(final String queryName, Object... params);

	/**
	 * Find using a named query
	 * 
	 * @param queryName
	 *            the name of the query
	 * @param params
	 *            the query parameters
	 * 
	 * @return the list of entities
	 */
	List<TYPE> findByNamedQueryAndNamedParams(final String queryName,
			final Map<String, ? extends Object> params);

	/**
	 * Count all entities
	 * 
	 * @return the number of entities
	 */
	int countAll();

	/**
	 * Count entities based on an example
	 * 
	 * @param exampleInstance
	 *            the search criteria
	 * @return the number of entities
	 */
	int countByExample(final TYPE exampleInstance);

	/**
	 * save an entity. This can be either a INSERT or UPDATE in the database
	 * 
	 * @param entity
	 *            the entity to save
	 * 
	 * @return the saved entity
	 */
	TYPE save(final TYPE entity);

	/**
	 * delete an entity from the database
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	void delete(final TYPE entity);
	
}
