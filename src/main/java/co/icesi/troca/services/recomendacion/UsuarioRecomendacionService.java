/**
 * 
 */
package co.icesi.troca.services.recomendacion;

import java.util.List;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioRecomendacion;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioRecomendacionService
 * @date 2/01/2014
 *
 */
public interface UsuarioRecomendacionService  extends GenericService<UsuarioRecomendacion, Integer>{

	
	/**
	 * Método que consulta las recomendaciones que ha recibido un determinado usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 3/01/2014
	* @param usuario
	* @return
	*/
	public List<UsuarioRecomendacion> findRecomendacionesByUsuario(Usuario usuario);
	
	/**
	 *Método que busca el registro de una recomendacion
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 3/01/2014
	* @param recomendador
	* @param recomendado
	* @return
	*/
	public List<UsuarioRecomendacion> findRecomendacionUsuario(Usuario recomendador, Usuario recomendado);
}
