/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.proyecto.ProyectoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImpl
 * @date 7/11/2013
 *
 */
@Repository("proyectoDao")
public class ProyectoDaoImpl extends GenericJpaRepository<Proyecto, Integer> implements ProyectoDao,Serializable {

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * FIELD_OWNER
	 */
	private static final String FIELD_OWNER = "owner";

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoDao#findProyectosByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Proyecto> findProyectosByUsuario(Usuario usuario) {
	Criterion criteria= Restrictions.eq(FIELD_OWNER, usuario);
		return findByCriteria(criteria);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoDao#findUltimosProyectos(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> findUltimosProyectos(int maxResults) {
		Order order = Order.desc("fechaRegistro");
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.addOrder(order);
		crit.setFirstResult(0);
		crit.setMaxResults(maxResults);
		
		return crit.list();
	}

	/* (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoDao#findProyectosByParam(java.lang.String)
	 */
	@Override
	public List<Proyecto> findProyectosByParam(String param) {
		Criterion criterion = Restrictions.like("nombre", param, MatchMode.ANYWHERE);
		return findByCriteria(criterion);
	}

}
