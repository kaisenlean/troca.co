/**
 * 
 */
package co.icesi.troca.services.noticia.comentario;

import java.util.List;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.services.GenericService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaComentarioService
 * @date 9/12/2013
 * 
 */
public interface NoticiaComentarioService extends
		GenericService<NoticiaComentario, Integer> {

	/**
	 * Método que consulta los comentarios de una noticia en concreto
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param noticia
	 * @return
	 */
	List<NoticiaComentario> findComentariosByNoticia(Noticia noticia);
}
