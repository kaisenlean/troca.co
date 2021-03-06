/**
 * 
 */
package co.icesi.troca.views.trueque;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeCalificacion;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.services.calificacion.CalificacionService;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.trueque.TruequeMensajeService;
import co.icesi.troca.services.trueque.TruequeService;
import co.icesi.troca.services.trueque.calificacion.TruequeCalificacionService;
import co.icesi.troca.views.login.Login;
import co.icesi.troca.views.perfil.PerfilDe;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanTrueque
 * @date 2/12/2013
 * 
 */
@ManagedBean
@ViewScoped
public class BeanTruequeMensaje extends BaseBean implements Serializable {

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         PAGINAS_TRUEQUE_MENSAJES
	 */
	private static final String PAGINAS_TRUEQUE_MENSAJES = "/paginas/trueque/mensajesTrueque.jsf";

	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Trueque trueque = new Trueque();

	@ManagedProperty(value = "#{login}")
	private Login login;

	@ManagedProperty(value = "#{truequeMensajeService}")
	private TruequeMensajeService truequeMensajeService;

	@ManagedProperty(value = "#{perfilDe}")
	private PerfilDe perfilDe;

	@ManagedProperty(value = "#{truequeService}")
	private TruequeService truequeService;

	@ManagedProperty(value = "#{notificacionService}")
	private NotificacionService notificacionService;

	@ManagedProperty(value = "#{truequeCalificacionService}")
	private TruequeCalificacionService truequeCalificacionService;

	@ManagedProperty(value = "#{calificacionService}")
	private CalificacionService calificacionService;

	private String respuesta;

	private boolean activoFinalizado;
	private boolean activoCancelado;
	private boolean activoEnviarMensaje;

	private TruequeCalificacion calificacion;
	private TruequeCalificacion calificacion2;

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/12/2013
	 */
	private void cambiarEstadoTrueque() {
		if (login.getUsuario().equals(trueque.getUsuarioTrueque1())) {
			trueque.setEstadoUsuario1(EstadoTruequeEnum.FINALIZADO);

		} else {
			trueque.setEstadoUsuario2(EstadoTruequeEnum.FINALIZADO);

		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.FINALIZADO)) {
			trueque.setEstado(EstadoTruequeEnum.FINALIZADO);
		}
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.FINALIZADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/12/2013
	 */
	private void cambiarEstadoTruequeCancelar() {
		if (login.getUsuario().equals(trueque.getUsuarioTrueque1())) {
			trueque.setEstadoUsuario1(EstadoTruequeEnum.CANCELADO);

		} else {
			trueque.setEstadoUsuario2(EstadoTruequeEnum.CANCELADO);

		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO)
				&& trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.ACTIVO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}

		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.ACTIVO)
				&& trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO)) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
	}

	public void cancelarTrueque() {
		cambiarEstadoTruequeCancelar();

		trueque = truequeService.save(trueque);

		calificacion.setUsuario(login.getUsuario());
		calificacion.setUsuarioCalificado(trueque.getUsuarioTrueque2().equals(
				login.getUsuario()) ? trueque.getUsuarioTrueque1() : trueque
				.getUsuarioTrueque2());
		calificacion.setTrueque(trueque);

		truequeCalificacionService.save(calificacion);

		Calificacion cal = new Calificacion();
		cal.setPuntajeText(calificacion.getPuntajeText());
		cal.setPuntajeVal(calificacion.getPuntajeVal());
		cal.setUsuario(trueque.getUsuarioTrueque2().equals(login.getUsuario()) ? trueque
				.getUsuarioTrueque1() : trueque.getUsuarioTrueque2());
		cal.setUsuarioRegistro(login.getUsuario());
		cal.setTrueque(trueque);
		calificacionService.save(cal);

		calificacion = new TruequeCalificacion();

		trueque = truequeService.findById(trueque.getId());
		this.trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));

		notificacionService.crearNotificacionCancelarTrueque(trueque,
				login.getUsuario());
		goTo(PAGINAS_TRUEQUE_MENSAJES);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 */
	public void enviarMensaje() {
		TruequeMensaje truequeMensaje = new TruequeMensaje();
		truequeMensaje.setFecha(Calendar.getInstance().getTime());
		truequeMensaje.setMensaje(respuesta);
		truequeMensaje.setTrueque(trueque);
		truequeMensaje.setUsuarioEmisor(login.getUsuario());
		truequeMensaje.setUsuarioReceptor(trueque.getUsuarioTrueque2().equals(
				login.getUsuario()) ? trueque.getUsuarioTrueque1() : trueque
				.getUsuarioTrueque2());
		truequeMensaje = truequeMensajeService.save(truequeMensaje);
		notificacionService.enviarNotificacionMensajeTrueque(truequeMensaje);
		this.trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));

		goTo(PAGINAS_TRUEQUE_MENSAJES);
	}

	public void finalizarTrueque() {
		cambiarEstadoTrueque();

		trueque = truequeService.save(trueque);

		calificacion2.setUsuario(login.getUsuario());
		calificacion2.setUsuarioCalificado(trueque.getUsuarioTrueque2().equals(
				login.getUsuario()) ? trueque.getUsuarioTrueque1() : trueque
				.getUsuarioTrueque2());
		calificacion2.setTrueque(trueque);

		truequeCalificacionService.save(calificacion2);

		Calificacion cal = new Calificacion();
		cal.setPuntajeText(calificacion2.getPuntajeText());
		cal.setPuntajeVal(calificacion2.getPuntajeVal());
		cal.setUsuario(trueque.getUsuarioTrueque2().equals(login.getUsuario()) ? trueque
				.getUsuarioTrueque1() : trueque.getUsuarioTrueque2());
		cal.setUsuarioRegistro(login.getUsuario());
		cal.setTrueque(trueque);
		calificacionService.save(cal);

		calificacion2 = new TruequeCalificacion();

		trueque = truequeService.findById(trueque.getId());
		this.trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));

		notificacionService.crearNotificacionFinalizarTrueque(trueque,
				login.getUsuario());

		goTo(PAGINAS_TRUEQUE_MENSAJES);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the calificacion
	 */
	public TruequeCalificacion getCalificacion() {
		return calificacion;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the perfilDe
	 */
	public PerfilDe getPerfilDe() {
		return perfilDe;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the trueque
	 */
	public Trueque getTrueque() {
		return trueque;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 */
	@PostConstruct
	public void init() {

		trueque = (Trueque) getAttribute("trueque");
		trueque = truequeService.findById(trueque.getId());
		trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));
		activoEnviarMensaje = true;
		if (trueque.getEstado().equals(EstadoTruequeEnum.CANCELADO)) {
			activoCancelado = true;
			activoFinalizado = true;
			activoEnviarMensaje = false;
			calificacion = new TruequeCalificacion();
			calificacion2 = new TruequeCalificacion();
			return;
		}

		if (trueque.getEstado().equals(EstadoTruequeEnum.FINALIZADO)) {
			activoCancelado = true;
			activoFinalizado = true;
			calificacion = new TruequeCalificacion();
			calificacion2 = new TruequeCalificacion();
			return;
		}

		if (login.getUsuario().equals(trueque.getUsuarioTrueque1())) {
			activoFinalizado = trueque.getEstadoUsuario1().equals(
					EstadoTruequeEnum.FINALIZADO);
			if (activoFinalizado) {
				activoCancelado = true;
				activoEnviarMensaje = false;
			} else {
				activoCancelado = trueque.getEstadoUsuario1().equals(
						EstadoTruequeEnum.CANCELADO);
			}

		} else {
			activoFinalizado = trueque.getEstadoUsuario2().equals(
					EstadoTruequeEnum.FINALIZADO);
			if (activoFinalizado) {
				activoCancelado = true;
				activoEnviarMensaje = false;
			} else {
				activoCancelado = trueque.getEstadoUsuario2().equals(
						EstadoTruequeEnum.CANCELADO);
			}
		}
		calificacion = new TruequeCalificacion();
		calificacion2 = new TruequeCalificacion();

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 * @return the activoCancelado
	 */
	public boolean isActivoCancelado() {
		return activoCancelado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 21/12/2013
	 * @return the activoEnviarMensaje
	 */
	public boolean isActivoEnviarMensaje() {
		return activoEnviarMensaje;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the activoFinalizado
	 */
	public boolean isActivoFinalizado() {
		return activoFinalizado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 * @param activoCancelado
	 *            the activoCancelado to set
	 */
	public void setActivoCancelado(boolean activoCancelado) {
		this.activoCancelado = activoCancelado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 21/12/2013
	 * @param activoEnviarMensaje
	 *            the activoEnviarMensaje to set
	 */
	public void setActivoEnviarMensaje(boolean activoEnviarMensaje) {
		this.activoEnviarMensaje = activoEnviarMensaje;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param activoFinalizado
	 *            the activoFinalizado to set
	 */
	public void setActivoFinalizado(boolean activoFinalizado) {
		this.activoFinalizado = activoFinalizado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificacion
	 *            the calificacion to set
	 */
	public void setCalificacion(TruequeCalificacion calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificacionService
	 *            the calificacionService to set
	 */
	public void setCalificacionService(CalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param notificacionService
	 *            the notificacionService to set
	 */
	public void setNotificacionService(NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param perfilDe
	 *            the perfilDe to set
	 */
	public void setPerfilDe(PerfilDe perfilDe) {
		this.perfilDe = perfilDe;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param trueque
	 *            the trueque to set
	 */
	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param truequeCalificacionService
	 *            the truequeCalificacionService to set
	 */
	public void setTruequeCalificacionService(
			TruequeCalificacionService truequeCalificacionService) {
		this.truequeCalificacionService = truequeCalificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param truequeMensajeService
	 *            the truequeMensajeService to set
	 */
	public void setTruequeMensajeService(
			TruequeMensajeService truequeMensajeService) {
		this.truequeMensajeService = truequeMensajeService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param truequeService
	 *            the truequeService to set
	 */
	public void setTruequeService(TruequeService truequeService) {
		this.truequeService = truequeService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 */
	public void verPageTrueque(Trueque trueque) {
		this.trueque = trueque;
		this.trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));
		goTo(PAGINAS_TRUEQUE_MENSAJES);
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/01/2014
	 * @return the calificacion2
	 */
	public TruequeCalificacion getCalificacion2() {
		return calificacion2;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/01/2014
	 * @param calificacion2 the calificacion2 to set
	 */
	public void setCalificacion2(TruequeCalificacion calificacion2) {
		this.calificacion2 = calificacion2;
	}
}
