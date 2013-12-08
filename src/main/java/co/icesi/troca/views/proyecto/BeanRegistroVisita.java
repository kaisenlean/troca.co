/**
 * 
 */
package co.icesi.troca.views.proyecto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoVisita;
import co.icesi.troca.services.proyecto.ProyectoVisitaService;
import co.icesi.troca.views.login.Login;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanRegistroVisita
 * @date 8/12/2013
 *
 */
@ManagedBean
@SessionScoped
public class BeanRegistroVisita extends BaseBean implements Serializable {

	/**
	 * 8/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 8/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectoVisitaService
	 */
	@ManagedProperty(value="#{proyectoVisitaService}")
	private ProyectoVisitaService proyectoVisitaService;

	
	/**
	 * 8/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * login
	 */
	@ManagedProperty(value="#{login}")
	private Login login;
	
	
	
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 8/12/2013
	* @param proyecto
	*/
	public void guardarVisita(Proyecto proyecto){
	ProyectoVisita visita=new ProyectoVisita();
	visita.setProyecto(proyecto);
	visita.setUsuario(login.getUsuario());
	proyectoVisitaService.save(visita);
	}
	
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param proyectoVisitaService the proyectoVisitaService to set
	 */
	public void setProyectoVisitaService(
			ProyectoVisitaService proyectoVisitaService) {
		this.proyectoVisitaService = proyectoVisitaService;
	}
}
