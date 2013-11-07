/**
 * 
 */
package co.icesi.troca.repositories.proyecto;

import java.util.List;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDao
 * @date 7/11/2013
 *
 */
public interface ProyectoDao extends GenericRepository<Proyecto, Integer> {

	
	/**
	 * Método que consulta los proyectos que ha creado o estan asignados a un usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 7/11/2013
	* @param usuario
	* @return
	 */
	public List<Proyecto> findProyectosByUsuario(Usuario usuario);
}
