/**
 * 
 */
package co.icesi.troca.repositories.proyecto;

import java.util.List;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDao
 * @date 7/11/2013
 * 
 */
public interface ProyectoTengoUsuarioDao extends
		GenericRepository<ProyectoTengoUsuario, Integer> {

	/**
	 * Método que Consulta los tengos por proyecto
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @param proyecto
	 * @return
	 */
	List<ProyectoTengoUsuario> findTengosByProyecto(Proyecto proyecto);

	/**
	 * Método que consulta un {@link ProyectoTengoUsuario} filtrado por
	 * {@link Tengo} y {@link Proyecto}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyecto
	 * @param tengo
	 * @return
	 */
	ProyectoTengoUsuario getByTengoAndProyecto(Proyecto proyecto, Tengo tengo);

}
