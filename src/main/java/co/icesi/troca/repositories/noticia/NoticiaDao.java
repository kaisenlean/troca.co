/**
 * 
 */
package co.icesi.troca.repositories.noticia;

import java.util.Date;
import java.util.List;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaDao
 * @date 31/10/2013
 *
 */
public interface NoticiaDao  extends GenericRepository<Noticia, Integer>{

	/**
	 * Metodo que consulta noticias publicadas en un rango de fechas
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @param start
	* @param end
	* @return
	 */
	public List<Noticia> findNoticiasByFechas( Date start , Date end);
}
