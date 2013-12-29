/**
 * 
 */
package co.icesi.troca.services.tengo;

import java.util.List;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoService
 * @date 31/10/2013
 * 
 */
public interface TengoService extends GenericService<Tengo, Integer> {

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @param proyecto
	 * @return
	 */
	List<Tengo> findTengoByParam(String param);

	/**
	 * Metodo que carga los {@link Tengo} de un usuario en especifico
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return {@link List<Tengo>}
	 */
	List<Tengo> findTengosByUsuario(Usuario usuario);

	/**
	 * Metodo que consulta los {@link Tengo} mas recientes registrados en el
	 * sistema
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @param maxResults
	 * @return
	 */
	List<Tengo> findUltimosTengo(int maxResults);

}
