/**
 * 
 */
package co.icesi.troca.services.necesito;

import java.util.List;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoService
 * @date 17/11/2013
 *
 */
public interface NecesitoService extends GenericService<Necesito, Integer>{

	/**
	 * 
	 * Metodo que consulta los ultimos necesitos registrados en el sistema
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/11/2013
	* @return
	 */
	public List<Necesito> findUltimosNecesito();
}
