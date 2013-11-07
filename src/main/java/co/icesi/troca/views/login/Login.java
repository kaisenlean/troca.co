package co.icesi.troca.views.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.Opcion;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.tengo.TipoTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.constants.OpcionConstants;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.tengo.TengoService;

/**
 * ManagedBean que controla los moovimiento y login del usuario
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class Login
 * @date 31/10/2013
 * 
 */
@ManagedBean
@SessionScoped
public class Login extends BaseBean implements Serializable {

	/**
	 * 1/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         SELECCIONA_UNA_CATEGORIA_TXT
	 */
	private static final String SELECCIONA_UNA_CATEGORIA_TXT = "- - Selecciona una categoria - -";

	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ES_UN_TEXT
	 */
	private static final String ES_UN_TEXT = "Es un ";

	/**
	 * 28/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String user;
	private String contrasena;
	private List<SelectItem> itemsTipoTengo = new ArrayList<SelectItem>();

	private Tengo tengo;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{opcionService}")
	private OpcionService opcionService;
	
	@ManagedProperty(value="#{proyectoService}")
	private ProyectoService proyectoService;
	
	@ManagedProperty(value="#{tengoService}")
	private TengoService tengoService;

	@PostConstruct
	public void init() {
		cargarItemTipoTengo();
		tengo = new Tengo();
		captureContextPath();

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 */
	private void captureContextPath() {
		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		String ctxPath = null;
		ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

		Opcion opcion = opcionService
				.findById(OpcionConstants.KEY_CONTEXT_PATH);
		if (opcion == null) {
			opcion=new Opcion();
			opcion.setKey(OpcionConstants.KEY_CONTEXT_PATH);
			opcion.setValue(ctxPath);
			opcionService.save(opcion);
		} else {
			opcion.setValue(ctxPath);
			opcionService.save(opcion);
		}
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	private void cargarItemTipoTengo() {
		itemsTipoTengo.add(new SelectItem("", new StringBuilder(
				SELECCIONA_UNA_CATEGORIA_TXT).toString()));
		for (int i = 0; i < TipoTengo.values().length; i++) {
			itemsTipoTengo.add(new SelectItem(TipoTengo.values()[i].name(),
					new StringBuilder(ES_UN_TEXT).append(
							TipoTengo.values()[i].name()).toString()));
		}

	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	public void loggedIn() {
		Usuario utemp = new Usuario();
		utemp.setEmail(user);
		utemp.setPassword(contrasena);
		usuario = usuarioService.loggedIn(utemp);
		usuario.setProyectos(proyectoService.findProyectosByUsuario(usuario));
		usuario.setTengos(tengoService.findTengosByUsuario(usuario));
		if (usuario == null) {
			runJavascript("Usuario no existe");
			return;
		}
		goTo("/index.jsf");
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/07/2013
	 */
	public void logOut() {
		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		String ctxPath = null;
		ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

		try {
			// Usar el contexto de JSF para invalidar la sesión,
			// NO EL DE SERVLETS (nada de HttpServletRequest)
			((HttpSession) ctx.getSession(false)).invalidate();

			// Redirección de nuevo con el contexto de JSF,
			// si se usa una HttpServletResponse fallará.
			// Sin embargo, como ya está fuera del ciclo de vida
			// de JSF se debe usar la ruta completa -_-U
			ctx.redirect(ctxPath + "/");
		} catch (IOException ex) {
			mensaje("Error", ex.toString());
		}
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param usuarioService
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 * @param opcionService
	 *            the opcionService to set
	 */
	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return
	 */
	public String getContrasena() {
		return contrasena;

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param contrasena
	 *            the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the itemsTipoTengo
	 */
	public List<SelectItem> getItemsTipoTengo() {
		return itemsTipoTengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param itemsTipoTengo
	 *            the itemsTipoTengo to set
	 */
	public void setItemsTipoTengo(List<SelectItem> itemsTipoTengo) {
		this.itemsTipoTengo = itemsTipoTengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the tengo
	 */
	public Tengo getTengo() {
		return tengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengo
	 *            the tengo to set
	 */
	public void setTengo(Tengo tengo) {
		this.tengo = tengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/11/2013
	 * @param proyectoService the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/11/2013
	 * @param tengoService the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}
}
