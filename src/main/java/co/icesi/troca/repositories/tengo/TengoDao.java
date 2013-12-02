/**
 * 
 */
package co.icesi.troca.repositories.tengo;

import java.util.List;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoDao
 * @date 31/10/2013
 * 
 */
public interface TengoDao extends GenericRepository<Tengo, Integer> {

	/**
	 * Metodo que consulta una lista de Tengos en base a un usuario en comun
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param usuario
	 * @return
	 */
	public List<Tengo> findTengosByUsuario(Usuario usuario);

	/**
	 * Metodo que consulta los tengos mas recientes en la base de datos
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @param maxResult
	 * @return
	 */
	public List<Tengo> findUltimosTengo(int maxResult);
	
	
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 29/11/2013
	* @param proyecto
	* @return
	*/
	public List<Tengo> findTengoByParam(String param);
}
