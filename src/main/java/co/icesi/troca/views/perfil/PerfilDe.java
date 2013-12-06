/**
 * 
 */
package co.icesi.troca.views.perfil;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.services.usuario.UsuarioLinkService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class PerfilDe
 * @date 2/12/2013
 *
 */
@ManagedBean
@SessionScoped
public class PerfilDe extends BaseBean implements Serializable{

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{opcionService}")
	private OpcionService opcionService;
	
	@ManagedProperty(value="#{proyectoService}")
	private ProyectoService proyectoService;
	
	@ManagedProperty(value="#{tengoService}")
	private TengoService tengoService;
	
	@ManagedProperty(value="#{noticiaService}")
	private NoticiaService noticiaService;
	
	@ManagedProperty(value="#{usuarioLinkService}")
	private UsuarioLinkService usuarioLinkService;
	
	
	
	private Usuario usuario=new Usuario();
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 2/12/2013
	* @param usuario
	*/
	public void loadPerfil(Usuario usuario){
		
		this.usuario=usuario;
		this.usuario.setProyectos(proyectoService.findProyectosByUsuario(usuario));
		this.usuario.setTengos(tengoService.findTengosByUsuario(usuario));
		this.usuario.setNoticias(noticiaService.findNoticiasByUsuario(usuario));
	goTo("/paginas/perfil/perfilDe.jsf");	
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
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
	 * @return the opcionService
	 */
	public OpcionService getOpcionService() {
		return opcionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param opcionService the opcionService to set
	 */
	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the proyectoService
	 */
	public ProyectoService getProyectoService() {
		return proyectoService;
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
	 * @return the tengoService
	 */
	public TengoService getTengoService() {
		return tengoService;
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
	 * @return the noticiaService
	 */
	public NoticiaService getNoticiaService() {
		return noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param noticiaService the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuarioLinkService
	 */
	public UsuarioLinkService getUsuarioLinkService() {
		return usuarioLinkService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuarioLinkService the usuarioLinkService to set
	 */
	public void setUsuarioLinkService(UsuarioLinkService usuarioLinkService) {
		this.usuarioLinkService = usuarioLinkService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}