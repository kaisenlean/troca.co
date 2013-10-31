package co.icesi.troca.repositories.noticia.impl;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.noticia.NoticiaDao;

/**
 * 
 */

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaDaoImpl
 * @date 31/10/2013
 *
 */
@Repository("noticiaDao")
public class NoticiaDaoImpl extends GenericJpaRepository<Noticia, Integer> implements NoticiaDao {

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.noticia.NoticiaDao#findNoticiasByFechas(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> findNoticiasByFechas(Date start, Date end) {
		Query query= getEntityManager().createQuery( new StringBuilder("select n from Noticia n where n.fecha between :start and :end").toString());
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getResultList();
	}

}
