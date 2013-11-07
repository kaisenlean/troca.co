/**
 * 
 */
package co.icesi.troca.services;

import co.icesi.troca.model.Opcion;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionService
 * @date 6/11/2013
 *
 */
public interface OpcionService  extends GenericService<Opcion,String>{

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 6/11/2013
	* @param key
	* @return
	 */
	public String getValueByKey(String key) throws Exception;
	
	
}
