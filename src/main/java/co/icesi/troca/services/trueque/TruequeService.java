/**
 * 
 */
package co.icesi.troca.services.trueque;

import java.util.List;

import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeService
 * @date 2/12/2013
 * 
 */
public interface TruequeService extends GenericService<Trueque, Integer> {

	/**
	 * Método que consulta los trueques activos de un usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param usuario
	 * @return
	 */
	List<Trueque> findActivosByUsuarioAndEstado(Usuario usuario,
			EstadoTruequeEnum estado);

}
