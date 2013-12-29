/**
 * 
 */
package co.icesi.troca.services.trueque;

import java.util.List;

import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeMensajeService
 * @date 2/12/2013
 * 
 */

public interface TruequeMensajeService extends
		GenericService<TruequeMensaje, Integer> {

	/**
	 * Método que consulta los mensajes por un trueque en específico
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param trueque
	 * @return
	 */
	List<TruequeMensaje> findMensajesByTrueque(Trueque trueque);
}
