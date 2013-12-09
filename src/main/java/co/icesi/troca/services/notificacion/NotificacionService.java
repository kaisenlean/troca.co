/**
 * 
 */
package co.icesi.troca.services.notificacion;

import java.util.List;

import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NotificacionService
 * @date 1/12/2013
 *
 */
public interface NotificacionService  extends GenericService<Notificacion, Integer>{

	
	/**
	 * Metodo que consulta las ultimas notificaciones enviadas a un usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param usuario
	* @return
	*/
	public List<Notificacion> findNotificacionesUsuario(Usuario usuario );
	
	/**
	 * Crea la notificacion de adicion de usuario a un nuevo proyecto
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param proyectoUsuario
	 */
	public void crearNotificacionAdicionProyecto(ProyectoUsuario proyectoUsuario);
	
	
	
	/**
	 * Crea la notificacion de solicitud de trueque tengo
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param truequeTengo
	 */
	public void crearNotificacionSolicitudTrueque(TruequeTengo truequeTengo,String mensaje);
	
	
	
	
	/**
	 * Método que envia mensaje en un trueque activo
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param truequeMensaje
	*/
	public void enviarNotificacionMensajeTrueque(TruequeMensaje truequeMensaje);
	
}
