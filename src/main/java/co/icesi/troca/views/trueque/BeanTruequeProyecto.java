/**
 * 
 */
package co.icesi.troca.views.trueque;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.services.trueque.TruequeMensajeService;
import co.icesi.troca.services.trueque.TruequeService;
import co.icesi.troca.services.trueque.TruequeTengoService;
import co.icesi.troca.views.login.Login;
import co.icesi.troca.views.perfil.PerfilDe;
import co.icesi.troca.views.proyecto.BeanProyecto;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanTrueque
 * @date 2/12/2013
 * 
 */
@ManagedBean
@ViewScoped
public class BeanTruequeProyecto extends BaseBean implements Serializable {

	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private int idTengo;

	private int idTengo2;

	private String mensaje;

	private String textOtro;

	private Trueque trueque = new Trueque();

	@ManagedProperty(value = "#{login}")
	private Login login;

	@ManagedProperty(value = "#{tengoService}")
	private TengoService tengoService;

	@ManagedProperty(value = "#{truequeMensajeService}")
	private TruequeMensajeService truequeMensajeService;

	@ManagedProperty(value = "#{perfilDe}")
	private PerfilDe perfilDe;

	@ManagedProperty(value = "#{truequeService}")
	private TruequeService truequeService;

	@ManagedProperty(value = "#{truequeTengoService}")
	private TruequeTengoService truequeTengoService;

	@ManagedProperty(value = "#{notificacionService}")
	private NotificacionService notificacionService;

	private List<Trueque> activos;

	private List<Trueque> finalizados;

	private List<Trueque> cancelados;

	@ManagedProperty("#{beanProyecto}")
	private BeanProyecto beanProyecto;

	@PostConstruct
	public void init() {

		activos = truequeService.findActivosByUsuarioAndEstado(
				login.getUsuario(), EstadoTruequeEnum.ACTIVO);
		cancelados = truequeService.findActivosByUsuarioAndEstado(
				login.getUsuario(), EstadoTruequeEnum.CANCELADO);
		finalizados = truequeService.findActivosByUsuarioAndEstado(
				login.getUsuario(), EstadoTruequeEnum.FINALIZADO);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 */
	public void realizarTrueque(Tengo tengo, int idTengo) {
		Tengo tenTemp = new Tengo();
		idTengo=this.idTengo;
		trueque = new Trueque();
		trueque.setEstado(EstadoTruequeEnum.ACTIVO);
		trueque.setUsuarioTrueque1(login.getUsuario());
		trueque.setUsuarioTrueque2(beanProyecto.getProyecto().getOwner());
		trueque.setProyecto(beanProyecto.getProyecto());
		TruequeTengo tt = new TruequeTengo();

		if (idTengo == 0) {

			tenTemp.setNombre(textOtro);
			tenTemp.setFechaRegistro(new Date());
			tenTemp.setOwner(beanProyecto.getProyecto().getOwner());
			tenTemp = tengoService.save(tenTemp);

		} else {
			tenTemp = tengoService.findById(idTengo);
			List<TruequeTengo> listTrueque = truequeTengoService
					.findByTengoAndSolicitante(tengo == null ? tenTemp : tengo,
							login.getUsuario());
			if (!listTrueque.isEmpty()) {
				mensajeError(new StringBuilder("Ya tienes ")
						.append(listTrueque.size())
						.append(" Solicitudes de trueques activas").toString());
				return;
			}
		}
		trueque.setEstadoUsuario1(EstadoTruequeEnum.ACTIVO);
		trueque.setEstadoUsuario2(EstadoTruequeEnum.ACTIVO);

		if (tenTemp.getOwner().equals(login.getUsuario())) {
			mensajeError("No puedes trocar  con tus propios tengos");
			return ;
		}
		trueque = truequeService.save(trueque);

		tt.setTengo(tenTemp);
		tt.setTengo2(tengo);
		tt.setTrueque(trueque);
		tt = truequeTengoService.save(tt);

		TruequeMensaje truequeMensaje = new TruequeMensaje();
		
		/* Envio de mensajes por aparte
		if (mensaje!=null) {
			if (!mensaje.trim().equals("")) {
				truequeMensaje.setMensaje(mensaje);
				truequeMensaje.setTrueque(trueque);
				truequeMensaje.setUsuarioEmisor(login.getUsuario());
				truequeMensaje.setUsuarioReceptor(perfilDe.getUsuario());
				truequeMensaje.setFecha(Calendar.getInstance().getTime());
				truequeMensajeService.save(truequeMensaje);
			}
		}
		*/
		mensaje = new StringBuilder("!!Hola , veo que tienen ")
				.append(tengo.getNombre())
				.append(" Yo lo necesito y a cambio te ofrezco ")
				.append(tenTemp.getNombre()).toString();
		truequeMensaje.setMensaje(mensaje);
		truequeMensaje.setTrueque(trueque);
		truequeMensaje.setUsuarioEmisor(login.getUsuario());
		truequeMensaje.setUsuarioReceptor(perfilDe.getUsuario());
		truequeMensaje.setFecha(new Date());
		truequeMensajeService.save(truequeMensaje);

		notificacionService.crearNotificacionSolicitudTrueque(tt, mensaje);
		mensaje = "";
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 */
	public void realizarTruequeN(Necesito necesito,int idTengo2) {
		Tengo tenTemp = new Tengo();
		trueque = new Trueque();
		trueque.setEstado(EstadoTruequeEnum.ACTIVO);
		trueque.setUsuarioTrueque1(login.getUsuario());
		trueque.setUsuarioTrueque2(beanProyecto.getProyecto().getOwner());
		trueque.setProyecto(beanProyecto.getProyecto());
		TruequeTengo tt = new TruequeTengo();

		if (idTengo2 == 0) {

			tenTemp.setNombre(textOtro);
			tenTemp.setFechaRegistro(new Date());
			tenTemp.setOwner(beanProyecto.getProyecto().getOwner());
			tenTemp = tengoService.save(tenTemp);

		} else {
			tenTemp = tengoService.findById(idTengo2);

		}
		trueque.setEstadoUsuario1(EstadoTruequeEnum.ACTIVO);
		trueque.setEstadoUsuario2(EstadoTruequeEnum.ACTIVO);
		
		trueque = truequeService.save(trueque);

		tt.setTengo(tenTemp);
		tt.setTrueque(trueque);
		tt.setNecesito(necesito);
		tt = truequeTengoService.save(tt);

		TruequeMensaje truequeMensaje = new TruequeMensaje();
		/* Envio de mensajes por aparte
		if (mensaje!=null) {
			if (!mensaje.trim().equals("")) {
				truequeMensaje.setMensaje(mensaje);
				truequeMensaje.setTrueque(trueque);
				truequeMensaje.setUsuarioEmisor(login.getUsuario());
				truequeMensaje.setUsuarioReceptor(perfilDe.getUsuario());
				truequeMensaje.setFecha(Calendar.getInstance().getTime());
				truequeMensajeService.save(truequeMensaje);
			}
		}
		*/
		mensaje = new StringBuilder("!!Hola , veo que necesitan ")
				.append(necesito.getNombre())
				.append(" Yo lo tengo y a cambio les ofrezco ")
				.append(tenTemp.getNombre()).toString();
		truequeMensaje.setMensaje(mensaje);
		truequeMensaje.setTrueque(trueque);
		truequeMensaje.setUsuarioEmisor(login.getUsuario());
		truequeMensaje.setUsuarioReceptor(perfilDe.getUsuario());
		truequeMensaje.setFecha(new Date());
		truequeMensajeService.save(truequeMensaje);

		notificacionService.crearNotificacionSolicitudTruequeProyecto(tt,
				mensaje);
		mensaje = "";
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 */
	public void verPnlTrueque(Trueque trueque) {
		this.trueque = trueque;
		this.trueque.setMensajes(truequeMensajeService
				.findMensajesByTrueque(trueque));
		addAttribute("trueque", this.trueque);
		goTo("/paginas/trueque/mensajesTrueque.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the idTengo
	 */
	public int getIdTengo() {
		return idTengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param idTengo
	 *            the idTengo to set
	 */
	public void setIdTengo(int idTengo) {
		this.idTengo = idTengo;
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
	 * @date 2/12/2013
	 * @param trueque
	 *            the trueque to set
	 */
	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
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
	 * @date 2/12/2013
	 * @return the perfilDe
	 */
	public PerfilDe getPerfilDe() {
		return perfilDe;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the textOtro
	 */
	public String getTextOtro() {
		return textOtro;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param textOtro
	 *            the textOtro to set
	 */
	public void setTextOtro(String textOtro) {
		this.textOtro = textOtro;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param tengoService
	 *            the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
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
	 * @date 9/12/2013
	 * @param truequeTengoService
	 *            the truequeTengoService to set
	 */
	public void setTruequeTengoService(TruequeTengoService truequeTengoService) {
		this.truequeTengoService = truequeTengoService;
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
	 * @date 9/12/2013
	 * @return the activos
	 */
	public List<Trueque> getActivos() {
		return activos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param activos
	 *            the activos to set
	 */
	public void setActivos(List<Trueque> activos) {
		this.activos = activos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the finalizados
	 */
	public List<Trueque> getFinalizados() {
		return finalizados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param finalizados
	 *            the finalizados to set
	 */
	public void setFinalizados(List<Trueque> finalizados) {
		this.finalizados = finalizados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the cancelados
	 */
	public List<Trueque> getCancelados() {
		return cancelados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param cancelados
	 *            the cancelados to set
	 */
	public void setCancelados(List<Trueque> cancelados) {
		this.cancelados = cancelados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 10/12/2013
	 * @param beanProyecto
	 *            the beanProyecto to set
	 */
	public void setBeanProyecto(BeanProyecto beanProyecto) {
		this.beanProyecto = beanProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 10/12/2013
	 * @return the idTengo2
	 */
	public int getIdTengo2() {
		return idTengo2;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 10/12/2013
	 * @param idTengo2
	 *            the idTengo2 to set
	 */
	public void setIdTengo2(int idTengo2) {
		this.idTengo2 = idTengo2;
	}
}
