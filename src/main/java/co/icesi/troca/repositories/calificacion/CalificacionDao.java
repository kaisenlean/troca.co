/**
 * 
 */
package co.icesi.troca.repositories.calificacion;

import java.util.List;

import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CalificacionDao
 * @date 9/12/2013
 *
 */
public interface CalificacionDao extends GenericRepository<Calificacion, Integer> {

	/**
	 * Método que busca las calificaciones en el sistema por un determinado usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param usuario
	* @return
	*/
	public List<Calificacion> findCalificacionByUsuario(Usuario usuario);
}
