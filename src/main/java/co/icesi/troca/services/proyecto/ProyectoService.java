/**
 * 
 */
package co.icesi.troca.services.proyecto;

import java.util.List;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoService
 * @date 7/11/2013
 * 
 */
public interface ProyectoService extends GenericService<Proyecto, Integer> {

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param maxResults
	 * @return
	 */
	List<Proyecto> findProyectosByParam(String param);

	/**
	 * Método que consulta los proyectos que ha creado o estan asignados a un
	 * usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/11/2013
	 * @param usuario
	 * @return
	 */
	List<Proyecto> findProyectosByUsuario(Usuario usuario);

	/**
	 * Metodo que consulta los ultimos proyectos ordenados ascendentemente por
	 * fecha de creación
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param maxResults
	 * @return
	 */
	List<Proyecto> findUltimosProyectos(int maxResults);

}
