package co.icesi.troca.services;

import java.util.List;

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
	
	

	/**
	 * Método que Consulta Usuarios por nombre , apellido o email
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 27/11/2013
	* @param param
	* @return
	 */
	public List<Usuario> findUsuariosByParam(String param);
	
	
	/**
	 * Método que consulta un usuario por email
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 11/12/2013
	* @param email
	* @return
	*/
	public Usuario findByEmail(String email);
}