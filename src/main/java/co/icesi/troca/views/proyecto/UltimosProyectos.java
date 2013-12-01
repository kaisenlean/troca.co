/**
 * 
 */
package co.icesi.troca.views.proyecto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.services.proyecto.ProyectoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UltimosProyectos
 * @date 1/12/2013
 *
 */
@ManagedBean
@RequestScoped
public class UltimosProyectos extends BaseBean implements Serializable {

	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectoService
	 */
	@ManagedProperty(value="#{proyectoService}")
	private ProyectoService proyectoService;  

	
	private List<Proyecto> proyectos;
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	@PostConstruct
	public void init(){
		proyectos=proyectoService.findUltimosProyectos(15);
		
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyectoService the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the proyectos
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
}
