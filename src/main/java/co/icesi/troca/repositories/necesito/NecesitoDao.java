/**
 * 
 */
package co.icesi.troca.repositories.necesito;

import java.util.List;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
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
	
	
	/**
	 * Método que consulta los necesitos por proyecto
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 29/11/2013
	* @param proyecto
	* @return
	*/
	public List<Necesito> findNecesitoByProyecto(Proyecto proyecto);
	
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 29/11/2013
	* @param proyecto
	* @return
	*/
	public List<Necesito> findNecesitoByParam(String param);
	
}
