/**
 * 
 */
package co.icesi.troca.services.notificacion;

import java.util.List;

import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.trueque.Trueque;
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
public interface NotificacionService extends
		GenericService<Notificacion, Integer> {

	/**
	 * Crea la notificacion de adicion de usuario a un nuevo proyecto
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyectoUsuario
	 */
	void crearNotificacionAdicionProyecto(ProyectoUsuario proyectoUsuario);

	/**
	 * Método que crea una notificacion para cancelar un trueque
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 * @param trueque
	 * @param usuario
	 */
	void crearNotificacionCancelarTrueque(Trueque trueque, Usuario usuario);

	/**
	 * Crea la notificacion de comentario en la noticia
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param truequeTengo
	 */
	void crearNotificacionComentarioNoticia(NoticiaComentario comentario);

	/**
	 * Métotodo que finaliza un trueque por parte de un usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 * @param trueque
	 * @param usuario
	 */
	void crearNotificacionFinalizarTrueque(Trueque trueque, Usuario usuario);

	/**
	 * Crea la notificacion de solicitud de trueque tengo
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param truequeTengo
	 */
	void crearNotificacionSolicitudTrueque(TruequeTengo truequeTengo,
			String mensaje);

	/**
	 * Crea la notificacion de solicitud de trueque tengo
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param truequeTengo
	 */
	void crearNotificacionSolicitudTruequeProyecto(TruequeTengo truequeTengo,
			String mensaje);

	/**
	 * Método que envia mensaje en un trueque activo
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param truequeMensaje
	 */
	void enviarNotificacionMensajeTrueque(TruequeMensaje truequeMensaje);

	/**
	 * Metodo que consulta las ultimas notificaciones enviadas a un usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param usuario
	 * @return
	 */
	List<Notificacion> findNotificacionesUsuario(Usuario usuario);
}
