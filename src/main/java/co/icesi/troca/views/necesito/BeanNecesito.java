/**
 * 
 */
package co.icesi.troca.views.necesito;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.services.necesito.NecesitoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanNecesito
 * @date 23/11/2013
 *
 */
@ManagedBean
@ViewScoped
public class BeanNecesito implements Serializable {

	/**
	 * 23/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 23/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * necesitoService
	 */
	@ManagedProperty(value="#{necesitoService}")
	private NecesitoService necesitoService;
	
	/**
	 * 23/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * listado
	 */
	private List<Necesito> listado;
	
	
	 /**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/11/2013
	*/
	@PostConstruct
	 public void init(){
		 listado=necesitoService.findUltimosNecesito();
		 
	 }
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 * @return the listado
	 */
	public List<Necesito> getListado() {
		return listado;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 * @param necesitoService the necesitoService to set
	 */
	public void setNecesitoService(NecesitoService necesitoService) {
		this.necesitoService = necesitoService;
	}

}
