/**
 * 
 */
package co.icesi.troca.repositories.calificacion.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.calificacion.CalificacionDao;
import co.icesi.troca.repositories.impl.GenericJpaRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CalificacionDaoImpl
 * @date 9/12/2013
 *
 */
@Repository("calificacionDao")
public class CalificacionDaoImpl extends GenericJpaRepository<Calificacion, Integer> implements Serializable,CalificacionDao {

	/**
	 * 19/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * TRUEQUE_FIELD
	 */
	private static final String TRUEQUE_FIELD = "trueque";
	/**
	 * 19/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * TRUEQUE_ESTADO_FIELD
	 */
	private static final String TRUEQUE_ESTADO_FIELD = "trueque.estado";
	/**
	 * 19/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * USUARIO_FIELD
	 */
	private static final String USUARIO_FIELD = "usuario";
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.calificacion.CalificacionDao#findCalificacionByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Calificacion> findCalificacionByUsuario(Usuario usuario) {
		Session session = getEntityManager().unwrap(Session.class);

		Criteria criterion = session.createCriteria(getEntityClass());
		criterion.createAlias(TRUEQUE_FIELD, TRUEQUE_FIELD);
		 criterion.add(Restrictions.conjunction().add(Restrictions.eq(USUARIO_FIELD, usuario)).add(Restrictions.eq(TRUEQUE_ESTADO_FIELD, EstadoTruequeEnum.FINALIZADO)));
		return criterion.list();
	}

}
