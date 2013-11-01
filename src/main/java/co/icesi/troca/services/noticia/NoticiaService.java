/**
 * 
 */
package co.icesi.troca.services.noticia;

import java.util.List;

import co.icesi.troca.model.noticia.Noticia;
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
}