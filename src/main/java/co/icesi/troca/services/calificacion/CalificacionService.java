/**
 * 
 */
package co.icesi.troca.services.calificacion;

import java.util.List;

import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CalificacionService
 * @date 9/12/2013
 *
 */
public interface CalificacionService extends GenericService<Calificacion, Integer> {

	/**
	 * Método que busca las calificaciones en el sistema por un determinado usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param usuario
	* @return
	*/
	public List<Calificacion> findCalificacionByUsuario(Usuario usuario);
	
	/**
	 * Método que busca las calificaciones de trueques cancelados en el sistema por un determinado usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param usuario
	* @return
	*/
	public List<Calificacion> findCalificacionByTruequeCanceladoByUsuario(Usuario usuario);
}
