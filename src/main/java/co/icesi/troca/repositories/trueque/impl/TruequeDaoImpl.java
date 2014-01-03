/**
 * 
 */
package co.icesi.troca.repositories.trueque.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.TruequeDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeDaoImpl
 * @date 2/12/2013
 * 
 */
@Repository("truequeDao")
public class TruequeDaoImpl extends GenericJpaRepository<Trueque, Integer>
		implements TruequeDao, Serializable {

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
	 * @see co.icesi.troca.repositories.trueque.TruequeDao#findActivosByUsuarioAndEstado(co.icesi.troca.model.usuario.Usuario,
	 *      co.icesi.troca.model.trueque.EstadoTruequeEnum)
	 */
	@Override
	public List<Trueque> findActivosByUsuarioAndEstado(Usuario usuario,
			EstadoTruequeEnum estado) {
		if (usuario==null) {
			return new ArrayList<Trueque>();
		}
		if (usuario.getId() == null) {
			return new ArrayList<Trueque>();
		}
		Criterion criterion = Restrictions.disjunction()
				.add(Restrictions.eq("usuarioTrueque1", usuario))
				.add(Restrictions.eq("usuarioTrueque2", usuario));

		Criterion criterion2 = Restrictions.eq("estado", estado);

		return findByCriteria(criterion, criterion2);
	}

}
