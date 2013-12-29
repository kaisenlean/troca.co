/**
 * 
 */
package co.icesi.troca.services.necesito;

import java.util.List;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoService
 * @date 17/11/2013
 * 
 */
public interface NecesitoService extends GenericService<Necesito, Integer> {

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @param proyecto
	 * @return
	 */
	 List<Necesito> findNecesitoByParam(String param);

	/**
	 * Método que consulta los necesitos por proyecto
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @param proyecto
	 * @return
	 */
	 List<Necesito> findNecesitoByProyecto(Proyecto proyecto);

	/**
	 * 
	 * Metodo que consulta los ultimos necesitos registrados en el sistema
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 * @return
	 */
	 List<Necesito> findUltimosNecesito();

	/**
	 * 
	 * Metodo que consulta los ultimos necesitos registrados en el sistema con
	 * maximo de resultados
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 * @return
	 */
	 List<Necesito> findUltimosNecesito(int maxResults);

}
