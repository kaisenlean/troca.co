/**
 * 
 */
package co.icesi.troca.repositories.trueque;

import java.util.List;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeTengoDao
 * @date 2/12/2013
 *
 */
public interface TruequeTengoDao extends GenericRepository<TruequeTengo, Integer>  {

	
	/**
	 * Método que consulta si hay trueques eb movimiento por usuario y tengo
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param tengo
	* @param usuario
	* @return
	*/
	public List<TruequeTengo> findByTengoAndSolicitante(Tengo tengo,Usuario usuario);
}
