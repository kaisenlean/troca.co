/**
 * 
 */
package co.icesi.troca.repositories.trueque;

import java.util.List;

import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeDao
 * @date 2/12/2013
 *
 */
public interface TruequeDao extends GenericRepository<Trueque, Integer> {

	
	
	/**
	 *Método que consulta los trueques activos de un usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param usuario
	* @return
	*/
	public List<Trueque> findActivosByUsuarioAndEstado(Usuario usuario,EstadoTruequeEnum estado);
}
