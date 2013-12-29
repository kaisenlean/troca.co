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
	 * Método que consulta un usuario por email
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 11/12/2013
	 * @param email
	 * @return
	 */
	Usuario findByEmail(String email);

	/**
	 * Método que Consulta Usuarios por nombre , apellido o email
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @param param
	 * @return
	 */
	List<Usuario> findUsuariosByParam(String param);

	/**
	 * Método que consulta un usuario por nombres y apellidos
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @param nameApellido
	 * @return
	 */
	Usuario getByNombreApellido(String nombre, String apellido);

	/**
	 * Metodo que busca un usuario en base de datos y le loguea en el sistema
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param usuario
	 * @return
	 */
	Usuario loggedIn(Usuario usuario);
}
