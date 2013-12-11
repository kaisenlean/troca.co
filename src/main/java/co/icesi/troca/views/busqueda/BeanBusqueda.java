/**
 * 
 */
package co.icesi.troca.views.busqueda;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.necesito.NecesitoService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.tengo.TengoService;


/**
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class BeanBusqueda
* @date 2/12/2013
*
*/
@ManagedBean
@SessionScoped
public class BeanBusqueda  extends BaseBean implements Serializable{

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{proyectoService}")
	private ProyectoService proyectoService;
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value="#{tengoService}")
	private TengoService  tengoService;
	
	@ManagedProperty(value="#{necesitoService}")
	private NecesitoService necesitoService;
	
	
	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuarios
	 */
	private List<Usuario> usuarios;
	
	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * tengos
	 */
	private List<Tengo> tengos;
	
	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * necesitos
	 */
	private List<Necesito> necesitos;
	
	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectos
	 */
	private List<Proyecto> proyectos;
	
	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * query
	 */
	private String query;
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 2/12/2013
	*/
	public void ejecutarBusqueda(){
		proyectos=proyectoService.findProyectosByParam(query);
		necesitos=necesitoService.findNecesitoByParam(query);
		tengos=tengoService.findTengoByParam(query);
		usuarios=usuarioService.findUsuariosByParam(query);
		query="";
		goTo("/paginas/busqueda.jsf");
		
		
	}

	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 2/12/2013
	*/
	public void buscar(){
		proyectos=proyectoService.findProyectosByParam(query);
		necesitos=necesitoService.findNecesitoByParam(query);
		tengos=tengoService.findTengoByParam(query);
		usuarios=usuarioService.findUsuariosByParam(query);
		query="";
		
		
		
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the tengos
	 */
	public List<Tengo> getTengos() {
		return tengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param tengos the tengos to set
	 */
	public void setTengos(List<Tengo> tengos) {
		this.tengos = tengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the necesitos
	 */
	public List<Necesito> getNecesitos() {
		return necesitos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param necesitos the necesitos to set
	 */
	public void setNecesitos(List<Necesito> necesitos) {
		this.necesitos = necesitos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the proyectos
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}


	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param proyectoService the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}


	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param tengoService the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}


	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param necesitoService the necesitoService to set
	 */
	public void setNecesitoService(NecesitoService necesitoService) {
		this.necesitoService = necesitoService;
	}


	
	
	
}
