/**
 * 
 */
package co.icesi.troca.views.proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.services.proyecto.ProyectoVisitaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class VisitaBean
 * @date 8/12/2013
 *
 */
@ManagedBean
@RequestScoped
public class VisitaBean extends BaseBean implements Serializable{

	/**
	 * 8/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * MAX_RESULTS_2
	 */
	private static final int MAX_RESULTS_2 = 15;

	/**
	 * 8/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * MAX_RESULTS
	 */
	private static final int MAX_RESULTS = 4;

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
	 * proyectos
	 */
	private List<Proyecto> proyectos=new ArrayList<Proyecto>();
	
	
	
	private List<Proyecto> proyectos2=new ArrayList<Proyecto>();
	
	
	@PostConstruct
	public void init(){
		try {
			proyectos=proyectoVisitaService.findProyectosMasVisitados( MAX_RESULTS);
			proyectos2=proyectoVisitaService.findProyectosMasVisitados(MAX_RESULTS_2);
		} catch (BaseException e) {
		mensajeError(e.toString());
		}
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
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @return the proyectos
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @return the proyectos2
	 */
	public List<Proyecto> getProyectos2() {
		return proyectos2;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param proyectos2 the proyectos2 to set
	 */
	public void setProyectos2(List<Proyecto> proyectos2) {
		this.proyectos2 = proyectos2;
	}

}
