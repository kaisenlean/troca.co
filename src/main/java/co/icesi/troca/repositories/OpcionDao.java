/**
 * 
 */
package co.icesi.troca.repositories;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.Opcion;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionDao
 * @date 6/11/2013
 * 
 */
public interface OpcionDao extends GenericRepository<Opcion, String> {

	/**
	 * Método que extrae el valor de la opcion segun una clave ingresada
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 * @param value
	 * @return
	 */
	String getValueByKey(String value) throws BaseException;
}
