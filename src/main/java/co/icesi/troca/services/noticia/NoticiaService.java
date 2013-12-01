/**
 * 
 */
package co.icesi.troca.services.noticia;

import java.util.List;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaService
 * @date 31/10/2013
 *
 */
public interface NoticiaService extends GenericService<Noticia, Integer> {

	/**
	 * Metodo que consulta las ultimas noticas publicadas entre ayer y hoy
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @return
	 */
	public List<Noticia> findUltimasNoticias();
	
	
	
	/**
	 * Metodo que consulta las ultimas noticas en orden descendente
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @return
	 */
	public List<Noticia> findUltimasNoticias(int maxResults);
	
	
	/**
	 * Metodo que consulta las noticias creadas por un usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	* @param usuario
	* @return
	 */
	public List<Noticia> findNoticiasByUsuario(Usuario usuario);
}
