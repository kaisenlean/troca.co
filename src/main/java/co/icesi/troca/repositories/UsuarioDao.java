package co.icesi.troca.repositories;

import java.util.List;

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
	
	
	/**
	 * Método que Consulta Usuarios por nombre , apellido o email
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 27/11/2013
	* @param param
	* @return
	 */
	public List<Usuario> findUsuariosByParam(String param);
	
	
	/**
	 * Método que consulta un usuario por nombres y apellidos
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 27/11/2013
	* @param nameApellido
	* @return
	 */
	public Usuario getByNombreApellido(String nombre,String apellido);
}
