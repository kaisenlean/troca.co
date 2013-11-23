/**
 * 
 */
package co.icesi.troca.repositories.necesito;

import java.util.List;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoDao
 * @date 17/11/2013
 *
 */
public interface NecesitoDao extends GenericRepository<Necesito, Integer> {

	/**
	 * Método que consulta los ultimos necesitos registrados en el sistema
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/11/2013
	* @return
	 */
	public List<Necesito> findUltimosNecesito(int maxResults);
	
}
