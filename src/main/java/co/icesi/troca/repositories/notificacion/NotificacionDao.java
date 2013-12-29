/**
 * 
 */
package co.icesi.troca.repositories.notificacion;

import java.util.List;

import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NotificacionDao
 * @date 1/12/2013
 * 
 */
public interface NotificacionDao extends
		GenericRepository<Notificacion, Integer> {

	/**
	 * Metodo que consulta las ultimas notificaciones enviadas a un usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param usuario
	 * @param maxResults
	 * @return
	 */
	List<Notificacion> findNotificacionesUsuario(Usuario usuario, int maxResults);

}
