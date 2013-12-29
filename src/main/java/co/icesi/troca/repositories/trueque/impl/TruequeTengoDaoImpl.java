/**
 * 
 */
package co.icesi.troca.repositories.trueque.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.TruequeTengoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeTengoDaoImpl
 * @date 2/12/2013
 * 
 */
@Repository("truequeTengoDao")
public class TruequeTengoDaoImpl extends
		GenericJpaRepository<TruequeTengo, Integer> implements TruequeTengoDao,
		Serializable {

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ESTADO_TRUEQUE_FIELD
	 */
	private static final String ESTADO_TRUEQUE_FIELD = "trueque.estado";
	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         TRUEQUE_USUARIO_TRUEQUE_FIELD
	 */
	private static final String TRUEQUE_USUARIO_TRUEQUE_FIELD = "trueque.usuarioTrueque1";
	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         TENGO_FIELD
	 */
	private static final String TENGO_FIELD = "tengo2";
	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.trueque.TruequeTengoDao#findByTengoAndSolicitante(co.icesi.troca.model.tengo.Tengo,
	 *      co.icesi.troca.model.usuario.Usuario)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TruequeTengo> findByTengoAndSolicitante(Tengo tengo,
			Usuario usuario) {
		Session session = getEntityManager().unwrap(Session.class);

		Criteria crit = session.createCriteria(getEntityClass());
		crit.createAlias("trueque", "trueque");
		Criterion criterion = Restrictions
				.conjunction()
				.add(Restrictions.eq(TENGO_FIELD, tengo))
				.add(Restrictions.eq(TRUEQUE_USUARIO_TRUEQUE_FIELD, usuario))
				.add(Restrictions.eq(ESTADO_TRUEQUE_FIELD,
						EstadoTruequeEnum.ACTIVO));
		crit.add(criterion);
		return crit.list();
	}

}
