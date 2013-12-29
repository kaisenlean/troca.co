/**
 * 
 */
package co.icesi.troca.repositories.usuario;

import java.util.List;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioLinkDao
 * @date 28/11/2013
 * 
 */
public interface UsuarioLinkDao extends GenericRepository<UsuarioLink, Integer> {

	/**
	 * Metodo que consulta los links por un usuario parametrizado
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuario
	 * @return
	 */
	List<UsuarioLink> getLinkByUsuario(Usuario usuario);

}
