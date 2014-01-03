/**
 * 
 */
package co.icesi.troca.repositories.recomendacion;

import java.util.List;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioRecomendacion;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @param <UsuarioRecomendacionDao>
 * @param <UsuarioRecomendacionDao>
 * @project troca-co
 * @class UsuarioRecomendacionDao
 * @date 2/01/2014
 *
 */
public interface UsuarioRecomendacionDao extends GenericRepository<UsuarioRecomendacion, Integer>{

	
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
