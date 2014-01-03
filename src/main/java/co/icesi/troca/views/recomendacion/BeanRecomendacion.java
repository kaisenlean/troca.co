/**
 * 
 */
package co.icesi.troca.views.recomendacion;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioRecomendacion;
import co.icesi.troca.services.recomendacion.UsuarioRecomendacionService;
import co.icesi.troca.views.login.Login;
import co.icesi.troca.views.perfil.PerfilDe;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanRecomendacion
 * @date 2/01/2014
 *
 */
@ManagedBean
@RequestScoped
public class BeanRecomendacion extends BaseBean implements Serializable {

	/**
	 * 2/01/2014
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@ManagedProperty(value="#{login}")
	private Login login;
	
	@ManagedProperty(value="#{perfilDe}")
	private PerfilDe perfilDe;
	
	@ManagedProperty(value="#{usuarioRecomendacionService}")
	private UsuarioRecomendacionService usuarioRecomendacionService;
	
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 3/01/2014
	*/
	public void recomendarUsuario(Usuario usuario){
		UsuarioRecomendacion recomendacion= new UsuarioRecomendacion();
		recomendacion.setUsuario(usuario);
		recomendacion.setUsuarioRecomienda(login.getUsuario());
		if (login.getUsuario() ==null) {
			mensajeError("Necesitas estar logueado para recomendar este usuario");
			return;
		}
		if (login.getUsuario().getId() ==null) {
			mensajeError("Necesitas estar logueado para recomendar este usuario");
			return;
		}
	
		
		usuarioRecomendacionService.save(recomendacion);
		mensaje("Hecho", "Se ha registrado la recomendación exitosamente");
		
	}
	
	

	public boolean isActivoRecomienda(){
		if (login.getUsuario().getId()==null) {
			return false;
		}
		if (perfilDe.getUsuario().getId()==null) {
			return false;
		}
		return usuarioRecomendacionService.findRecomendacionUsuario(login.getUsuario(), perfilDe.getUsuario()).isEmpty();
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @return the usuarioRecomendacionService
	 */
	public UsuarioRecomendacionService getUsuarioRecomendacionService() {
		return usuarioRecomendacionService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @param usuarioRecomendacionService the usuarioRecomendacionService to set
	 */
	public void setUsuarioRecomendacionService(
			UsuarioRecomendacionService usuarioRecomendacionService) {
		this.usuarioRecomendacionService = usuarioRecomendacionService;
	}



	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @return the perfilDe
	 */
	public PerfilDe getPerfilDe() {
		return perfilDe;
	}



	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/01/2014
	 * @param perfilDe the perfilDe to set
	 */
	public void setPerfilDe(PerfilDe perfilDe) {
		this.perfilDe = perfilDe;
	}
	
	

}
