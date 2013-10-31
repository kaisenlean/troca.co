package co.icesi.troca.services;

import co.icesi.troca.model.usuario.Usuario;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class UsuarioService
* @date 22/10/2013
*
 */
public interface UsuarioService  extends GenericService<Usuario, Integer>{

	
	/**
	 *Método que busca un usuario en la base de datos para ser logeado en el sistema
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @param usuario
	* @return {@link Usuario}
	 */
	public Usuario loggedIn(Usuario usuario);
}