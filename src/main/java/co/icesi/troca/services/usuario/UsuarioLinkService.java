/**
 * 
 */
package co.icesi.troca.services.usuario;

import java.util.List;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioLinkService
 * @date 28/11/2013
 *
 */
public interface UsuarioLinkService extends GenericService<UsuarioLink, Integer> {
	/**
	 * Metodo que consulta los links por un usuario parametrizado
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 28/11/2013
	* @param usuario
	* @return
	 */
	public List<UsuarioLink> getLinkByUsuario(Usuario usuario);
}
