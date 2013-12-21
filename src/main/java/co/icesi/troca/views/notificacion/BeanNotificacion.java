/**
 * 
 */
package co.icesi.troca.views.notificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.notificacion.Modulo;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.trueque.TruequeService;
import co.icesi.troca.views.login.Login;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanNotificacion
 * @date 9/12/2013
 *
 */
@ManagedBean
@RequestScoped
public class BeanNotificacion extends BaseBean implements Serializable{

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * notificacionService
	 */
	@ManagedProperty(value="#{notificacionService}")
	private NotificacionService notificacionService;
	
	
	
	@ManagedProperty(value="#{truequeService}")
	private TruequeService truequeService;
	
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * login
	 */
	@ManagedProperty(value="#{login}")
	private Login login;
	
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * lista
	 */
	private List<Notificacion> lista;
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	*/
	@PostConstruct
	public void init(){
		if (login.getUsuario()!=null) {
			if (login.getUsuario().getId()!=null) {
				
				lista=notificacionService.findNotificacionesUsuario(login.getUsuario());
			}else{
				lista=new ArrayList<Notificacion>();
				
			}
		}else{
			lista=new ArrayList<Notificacion>();
			
		}
		
	}
	
	
	public String mensajeComplementario(Notificacion notificacion){
		
		if (notificacion.getModulo().equals(Modulo.TRUEQUE_NECESITO) | notificacion.getModulo().equals(Modulo.TRUEQUE_TENGO)) {
			try {
				Trueque trueque= truequeService.findById(Integer.valueOf(notificacion.getReferenceId()));
				if (trueque==null) {
					return "";
				}
				return " en tu proyecto "+trueque.getProyecto();
			} catch (Exception e) {
				return "";
			}
		}
		return"";}
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the lista
	 */
	public List<Notificacion> getLista() {
		return lista;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param lista the lista to set
	 */
	public void setLista(List<Notificacion> lista) {
		this.lista = lista;
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
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 20/12/2013
	 * @param truequeService the truequeService to set
	 */
	public void setTruequeService(TruequeService truequeService) {
		this.truequeService = truequeService;
	}

}
