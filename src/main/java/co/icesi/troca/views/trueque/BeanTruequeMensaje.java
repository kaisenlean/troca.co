/**
 * 
 */
package co.icesi.troca.views.trueque;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeCalificacion;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.services.trueque.TruequeMensajeService;
import co.icesi.troca.services.trueque.TruequeService;
import co.icesi.troca.services.trueque.TruequeTengoService;
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
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	
	private Trueque trueque= new Trueque();
	
	
	@ManagedProperty(value="#{login}")
	private Login login;
	
	@ManagedProperty(value="#{tengoService}")
	private TengoService tengoService;
	
	@ManagedProperty(value="#{truequeMensajeService}")
	private TruequeMensajeService truequeMensajeService;
	
	@ManagedProperty(value="#{perfilDe}")
	private PerfilDe perfilDe;
	
	@ManagedProperty(value="#{truequeService}")
	private TruequeService truequeService;
	
	@ManagedProperty(value="#{truequeTengoService}")
	private TruequeTengoService truequeTengoService;
	
	@ManagedProperty(value="#{notificacionService}")
	private NotificacionService notificacionService;
	
	
	@ManagedProperty(value="#{truequeCalificacionService}")
	private TruequeCalificacionService truequeCalificacionService;  
	
	private String respuesta;
	
	private boolean activoFinalizado;
	
	
	private TruequeCalificacion calificacion;
	
	@PostConstruct
	public void init(){
		
		trueque=(Trueque) getAttribute("trueque");
		if (login.getUsuario().equals(trueque.getUsuarioTrueque1())) {
			activoFinalizado=!trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO) ;
		}else{
			activoFinalizado=!trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.FINALIZADO);
			
		}
		calificacion=new TruequeCalificacion();
	}
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	*/
	public void verPageTrueque(Trueque trueque){
		this.trueque=trueque;
		this.trueque.setMensajes(truequeMensajeService.findMensajesByTrueque(trueque));
		goTo("/paginas/trueque/mensajesTrueque.jsf");
	}
	

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	*/
	public void enviarMensaje(){
		TruequeMensaje truequeMensaje=new TruequeMensaje();
		truequeMensaje.setFecha(new Date());
		truequeMensaje.setMensaje(respuesta);
		truequeMensaje.setTrueque(trueque);
		truequeMensaje.setUsuarioEmisor(login.getUsuario());
		truequeMensaje.setUsuarioReceptor(trueque.getUsuarioTrueque2().equals(login.getUsuario())?trueque.getUsuarioTrueque1():trueque.getUsuarioTrueque2());
		truequeMensaje=truequeMensajeService.save(truequeMensaje);
		notificacionService.enviarNotificacionMensajeTrueque(truequeMensaje);
		this.trueque.setMensajes(truequeMensajeService.findMensajesByTrueque(trueque));
		
		goTo("/paginas/trueque/mensajesTrueque.jsf");
	}
	
	

	public void finalizarTrueque(){
		if (login.getUsuario().equals(trueque.getUsuarioTrueque1())) {
			trueque.setEstadoUsuario1(EstadoTruequeEnum.FINALIZADO);
			
		}else{
			trueque.setEstadoUsuario2(EstadoTruequeEnum.FINALIZADO);
			
		}
		
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO) && trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.FINALIZADO) ) {
			trueque.setEstado(EstadoTruequeEnum.FINALIZADO);
		}
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO) && trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.FINALIZADO) ) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
		
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.CANCELADO) && trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.CANCELADO) ) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
		
		if (trueque.getEstadoUsuario1().equals(EstadoTruequeEnum.FINALIZADO) && trueque.getEstadoUsuario2().equals(EstadoTruequeEnum.CANCELADO) ) {
			trueque.setEstado(EstadoTruequeEnum.CANCELADO);
		}
		
		trueque=truequeService.save(trueque);
		
		calificacion.setUsuario(login.getUsuario());
		calificacion.setUsuarioCalificado(trueque.getUsuarioTrueque2().equals(login.getUsuario())?trueque.getUsuarioTrueque1():trueque.getUsuarioTrueque2());
		calificacion.setTrueque(trueque);
		
		truequeCalificacionService.save(calificacion);
		calificacion=new TruequeCalificacion();
		removeAttribute("trueque");
		addAttribute("trueque", trueque);
		init();
		goTo("/paginas/trueque/mensajesTrueque.jsf");
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
	 * @param trueque the trueque to set
	 */
	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
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
 * @param login the login to set
 */
public void setLogin(Login login) {
	this.login = login;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @param perfilDe the perfilDe to set
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
 * @date 8/12/2013
 * @param tengoService the tengoService to set
 */
public void setTengoService(TengoService tengoService) {
	this.tengoService = tengoService;
}


/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 8/12/2013
 * @param truequeService the truequeService to set
 */
public void setTruequeService(TruequeService truequeService) {
	this.truequeService = truequeService;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 8/12/2013
 * @param truequeMensajeService the truequeMensajeService to set
 */
public void setTruequeMensajeService(TruequeMensajeService truequeMensajeService) {
	this.truequeMensajeService = truequeMensajeService;
}


/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 9/12/2013
 * @param truequeTengoService the truequeTengoService to set
 */
public void setTruequeTengoService(TruequeTengoService truequeTengoService) {
	this.truequeTengoService = truequeTengoService;
}


/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 9/12/2013
 * @param notificacionService the notificacionService to set
 */
public void setNotificacionService(NotificacionService notificacionService) {
	this.notificacionService = notificacionService;
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
 * @date 9/12/2013
 * @param respuesta the respuesta to set
 */
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
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
 * @date 9/12/2013
 * @param activoFinalizado the activoFinalizado to set
 */
public void setActivoFinalizado(boolean activoFinalizado) {
	this.activoFinalizado = activoFinalizado;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 9/12/2013
 * @param truequeCalificacionService the truequeCalificacionService to set
 */
public void setTruequeCalificacionService(
		TruequeCalificacionService truequeCalificacionService) {
	this.truequeCalificacionService = truequeCalificacionService;
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
 * @date 9/12/2013
 * @param calificacion the calificacion to set
 */
public void setCalificacion(TruequeCalificacion calificacion) {
	this.calificacion = calificacion;
}


}
