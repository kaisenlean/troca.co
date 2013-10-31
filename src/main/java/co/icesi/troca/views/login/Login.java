package co.icesi.troca.views.login;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;

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
	 * 28/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String user;
	private String contrasena;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@PostConstruct
	public void init() {
//		user=new String();
//		contrasena=new String();

	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	public void loggedIn() {
		Usuario utemp= new Usuario();
		utemp.setEmail(user);
		utemp.setPassword(contrasena);
		usuario=usuarioService.loggedIn(utemp);
		if (usuario==null) {
			runJavascript("Usuario no existe");
			return ;
		}
		goTo("/index.jsf");
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
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
