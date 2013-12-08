/**
 * 
 */
package co.icesi.troca.services.proyecto;

import java.util.List;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoVisita;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoVisitaService
 * @date 8/12/2013
 *
 */
public interface ProyectoVisitaService extends GenericService<ProyectoVisita, Integer> {

	
	
	/**
	 * Guardar una visita en la base de datos
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 8/12/2013
	* @param proyecto
	* @param usuario
	* @throws BaseException
	*/
	public void registrarVisita(Proyecto proyecto , Usuario usuario) throws BaseException ;
	
	
	/**
	 * Método que consulta los proyectos destacados
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 8/12/2013
	* @return
	* @throws BaseException
	*/
	public List<Proyecto> findProyectosMasVisitados(int maxResults)throws BaseException;
}
