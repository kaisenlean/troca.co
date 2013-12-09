/**
 * 
 */
package co.icesi.troca.repositories.trueque;

import java.util.List;

import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeMensajeDao
 * @date 2/12/2013
 *
 */
public interface TruequeMensajeDao extends GenericRepository<TruequeMensaje, Integer>
{

	/**
	 * Método que consulta los mensajes por un trueque en específico
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param trueque
	* @return
	*/
	public List<TruequeMensaje> findMensajesByTrueque(Trueque trueque);
}
