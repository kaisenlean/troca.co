/**
 * 
 */
package co.icesi.troca.repositories.necesito.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.necesito.NecesitoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoDaoImpl
 * @date 17/11/2013
 * 
 */
@Repository("necesitoDao")
public class NecesitoDaoImpl extends GenericJpaRepository<Necesito, Integer>
		implements Serializable, NecesitoDao {

	/**
	 * 17/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.necesito.NecesitoDao#findNecesitoByParam(java.lang.String)
	 */
	@Override
	public List<Necesito> findNecesitoByParam(String param) {
		Criterion criterion = Restrictions.like("nombre", param,
				MatchMode.ANYWHERE);
		return findByCriteria(criterion);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.necesito.NecesitoDao#findNecesitoByProyecto(co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public List<Necesito> findNecesitoByProyecto(Proyecto proyecto) {
		Criterion criterion = Restrictions.eq("proyecto", proyecto);
		return findByCriteria(criterion);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.necesito.NecesitoDao#findUltimosNecesito(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Necesito> findUltimosNecesito(int maxResults) {
		Order order = Order.desc("fechaCreacion");
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.addOrder(order);
		crit.setFirstResult(0);
		crit.setMaxResults(maxResults);

		return crit.list();
	}

}
