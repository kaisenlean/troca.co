/**
 * 
 */
package co.icesi.troca.repositories.tengo.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.tengo.TengoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoDaoImpl
 * @date 31/10/2013
 * 
 */
@Repository("tengoDao")
public class TengoDaoImpl extends GenericJpaRepository<Tengo, Integer>
		implements TengoDao, Serializable {

	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         FIELD_OWNER
	 */
	private static final String FIELD_OWNER = "owner";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.tengo.TengoDao#findTengoByParam(java.lang.String)
	 */
	@Override
	public List<Tengo> findTengoByParam(String param) {

		Criterion criterion = Restrictions.like("descripcion", param,
				MatchMode.ANYWHERE);

		return findByCriteria(criterion);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.tengo.TengoDao#findTengosByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Tengo> findTengosByUsuario(Usuario usuario) {
		Criterion c = Restrictions.eq(FIELD_OWNER, usuario);
		return findByCriteria(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.tengo.TengoDao#findUltimosTengo(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tengo> findUltimosTengo(int maxResult) {
		Order order = Order.desc("fechaRegistro");
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.addOrder(order);
		crit.setFirstResult(0);
		crit.setMaxResults(maxResult);

		return crit.list();

	}

}
