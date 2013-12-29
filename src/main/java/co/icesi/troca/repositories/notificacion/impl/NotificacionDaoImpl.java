/**
 * 
 */
package co.icesi.troca.repositories.notificacion.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.notificacion.EstadoNotificacion;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.notificacion.NotificacionDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NotificacionDaoImpl
 * @date 1/12/2013
 * 
 */
@Repository("notificacionDao")
public class NotificacionDaoImpl extends
		GenericJpaRepository<Notificacion, Integer> implements NotificacionDao,
		Serializable {

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.notificacion.NotificacionDao#findNotificacionesUsuario(co.icesi.troca.model.usuario.Usuario,
	 *      int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Notificacion> findNotificacionesUsuario(Usuario usuario,
			int maxResults) {
		Order order = Order.desc("fecha");
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.add(Restrictions.eq("usuario", usuario));
		crit.add(Restrictions.eq("estado", EstadoNotificacion.NO_VISTA));
		crit.addOrder(order);
		crit.setFirstResult(0);
		crit.setMaxResults(maxResults);

		return crit.list();

	}

}
