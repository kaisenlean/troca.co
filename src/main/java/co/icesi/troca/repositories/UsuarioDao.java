package co.icesi.troca.repositories;

import co.icesi.troca.model.usuario.Usuario;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class UsuarioDAO
* @date 22/10/2013
*
 */
public interface UsuarioDao extends GenericRepository<Usuario, Integer> {
	
	/**
	 * Metodo que busca un usuario en base de datos y le loguea en el sistema
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @param usuario
	* @return
	 */
	public Usuario loggedIn(Usuario usuario);
}
