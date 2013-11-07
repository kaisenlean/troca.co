package co.icesi.troca.repositories.noticia.impl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
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
public class NoticiaDaoImpl extends GenericJpaRepository<Noticia, Integer> implements NoticiaDao ,Serializable {

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.noticia.NoticiaDao#findNoticiasByFechas(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> findNoticiasByFechas(Date start, Date end) {
		Query query= getEntityManager().createQuery( new StringBuilder("select n from Noticia n where n.fecha between :start and :end").toString());
		query.setParameter("start", start);
		query.setParameter("end", end);
		
		List<Noticia> resultList = query.getResultList();
		
		return resultList;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.noticia.NoticiaDao#findUltimasNoticias(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> findUltimasNoticias(int limit) {
		Order order = Order.desc("fecha");
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.addOrder(order);
		crit.setFirstResult(0);
		crit.setMaxResults(limit);
		
		return crit.list();
	}

}
