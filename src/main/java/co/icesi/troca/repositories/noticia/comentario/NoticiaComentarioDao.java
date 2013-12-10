/**
 * 
 */
package co.icesi.troca.repositories.noticia.comentario;

import java.util.List;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaComentarioDao
 * @date 9/12/2013
 *
 */
public interface NoticiaComentarioDao extends GenericRepository<NoticiaComentario, Integer>{

	
	
	/**
	 * Método que consulta los comentarios de una noticia en concreto
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @param noticia
	* @return
	*/
	public List<NoticiaComentario> findComentariosByNoticia(Noticia noticia);
}
