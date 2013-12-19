/**
 * 
 */
package co.icesi.troca.repositories.proyecto;

import java.util.List;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoUsuarioDao
 * @date 1/12/2013
 *
 */
public interface ProyectoUsuarioDao  extends GenericRepository<ProyectoUsuario, Integer>{
	
	
	/**
	 * Método que consulta un registro de {@link ProyectoUsuario} por criterio de {@link Usuario} y {@link Proyecto}
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param usuario
	* @param proyecto
	* @return
	*/
	public ProyectoUsuario getByUsuarioAndProyecto(Usuario usuario,Proyecto proyecto);
	
	
	
	/**
	 * Método que consulta los usuarios relacionados a un proyecto parametrizado
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param proyecto
	* @return
	*/
	public List<ProyectoUsuario> findByProyecto(Proyecto proyecto);
	
	
	
	/**
	 * Método que extrae los proyectos por un usuario en especifico
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 19/12/2013
	* @param usuario
	* @return
	*/
	public List<Proyecto> findByUsuario(Usuario usuario);

}
