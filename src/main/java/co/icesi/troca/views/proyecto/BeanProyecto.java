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
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.services.necesito.CategoriaNecesitoService;
import co.icesi.troca.services.necesito.NecesitoService;
import co.icesi.troca.services.proyecto.ProyectoCategoriaService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService;
import co.icesi.troca.views.login.Login;
/**
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class BeanProyecto
* @date 24/11/2013
*
*/
@ManagedBean
@ViewScoped
public class BeanProyecto extends BaseBean implements Serializable {

	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * login
	 */
	@ManagedProperty(value="#{login}")
	private Login login;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectoService
	 */
	@ManagedProperty(value="#{proyectoService}")
	private ProyectoService proyectoService;
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaNecesitoService
	 */
	@ManagedProperty(value="#{categoriaNecesitoService}")
	private CategoriaNecesitoService categoriaNecesitoService;
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * necesitoService
	 */
	@ManagedProperty(value="#{necesitoService}")
	private NecesitoService necesitoService;
	
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectoCategoriaService
	 */
	@ManagedProperty(value="#{proyectoCategoriaService}")
	private ProyectoCategoriaService proyectoCategoriaService;
	
	
	
	@ManagedProperty(value="#{proyectoTengoUsuarioService}")
	private ProyectoTengoUsuarioService proyectoTengoUsuarioService;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyecto
	 */
	private Proyecto proyecto=new Proyecto();
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * necesitosProyecto
	 */
	private List<Necesito> necesitosProyecto=new ArrayList<Necesito>();
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaNecesito
	 */
	private int categoriaNecesito;
	
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaProyecto
	 */
	private int categoriaProyecto;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * nombreNecesito
	 */
	private String nombreNecesito;
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * descripcionNecesito
	 */
	private String descripcionNecesito;
	
	
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	*/
	public void agregarNecesito(){
		Necesito necesito= new Necesito();
		necesito.setDescripcion(descripcionNecesito);
		necesito.setNombre(nombreNecesito);
		if (categoriaNecesito==0) {
			mensajeError("Por favor selecciona una categoria válida");
		return;	
		}
		necesito.setCategoria(categoriaNecesitoService.findById(categoriaNecesito));
		necesitosProyecto.add(necesito);
		init();
		
	}
	
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	 */
	public void guardarProyecto(){
		if (categoriaProyecto==0) {
			mensajeError("Selecciona una categoria valida para el proyecto");
			return;
		}
		
		
		
		proyecto.setCategoria(proyectoCategoriaService.findById(categoriaProyecto));
		proyecto.setOwner(login.getUsuario());
		proyecto =proyectoService.save(proyecto);
		for (Necesito necesito : necesitosProyecto) {
			necesito.setProyecto(proyecto);
			necesito.setUsuario(login.getUsuario());
			
			necesitoService.save(necesito);
			
		}		
		
		for (Tengo tengo : login.getUsuario().getTengos()) {
			if (tengo.isSeleccionado()) {
				
			
				ProyectoTengoUsuario tengoUsuario = new ProyectoTengoUsuario();
				tengoUsuario.setProyecto(proyecto);
				tengoUsuario.setTengo(tengo);
				proyectoTengoUsuarioService.save(tengoUsuario);
			}
			tengo.setSeleccionado(false);
		}
	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	*/
	@PostConstruct
	private void init() {
		nombreNecesito="";
		descripcionNecesito="";
	}



	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoService the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaNecesito
	 */
	public int getCategoriaNecesito() {
		return categoriaNecesito;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaNecesito the categoriaNecesito to set
	 */
	public void setCategoriaNecesito(int categoriaNecesito) {
		this.categoriaNecesito = categoriaNecesito;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the descripcionNecesito
	 */
	public String getDescripcionNecesito() {
		return descripcionNecesito;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param descripcionNecesito the descripcionNecesito to set
	 */
	public void setDescripcionNecesito(String descripcionNecesito) {
		this.descripcionNecesito = descripcionNecesito;
	}
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the nombreNecesito
	 */
	public String getNombreNecesito() {
		return nombreNecesito;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param nombreNecesito the nombreNecesito to set
	 */
	public void setNombreNecesito(String nombreNecesito) {
		this.nombreNecesito = nombreNecesito;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaNecesitoService the categoriaNecesitoService to set
	 */
	public void setCategoriaNecesitoService(
			CategoriaNecesitoService categoriaNecesitoService) {
		this.categoriaNecesitoService = categoriaNecesitoService;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaNecesitoService
	 */
	public CategoriaNecesitoService getCategoriaNecesitoService() {
		return categoriaNecesitoService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param necesitosProyecto the necesitosProyecto to set
	 */
	public void setNecesitosProyecto(List<Necesito> necesitosProyecto) {
		this.necesitosProyecto = necesitosProyecto;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param necesitoService the necesitoService to set
	 */
	public void setNecesitoService(NecesitoService necesitoService) {
		this.necesitoService = necesitoService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaProyecto
	 */
	public int getCategoriaProyecto() {
		return categoriaProyecto;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaProyecto the categoriaProyecto to set
	 */
	public void setCategoriaProyecto(int categoriaProyecto) {
		this.categoriaProyecto = categoriaProyecto;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoCategoriaService the proyectoCategoriaService to set
	 */
	public void setProyectoCategoriaService(
			ProyectoCategoriaService proyectoCategoriaService) {
		this.proyectoCategoriaService = proyectoCategoriaService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoTengoUsuarioService the proyectoTengoUsuarioService to set
	 */
	public void setProyectoTengoUsuarioService(
			ProyectoTengoUsuarioService proyectoTengoUsuarioService) {
		this.proyectoTengoUsuarioService = proyectoTengoUsuarioService;
	}
}
