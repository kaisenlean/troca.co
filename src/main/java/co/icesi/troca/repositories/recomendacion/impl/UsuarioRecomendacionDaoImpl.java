/**
 * 
 */
package co.icesi.troca.repositories.recomendacion.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioRecomendacion;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.recomendacion.UsuarioRecomendacionDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioRecomendacionDaoImpl
 * @date 2/01/2014
 *
 */
@Repository("usuarioRecomendacionDao")
public class UsuarioRecomendacionDaoImpl extends GenericJpaRepository<UsuarioRecomendacion, Integer> implements UsuarioRecomendacionDao{

	/**
	 * 3/01/2014
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * USUARIO_RECOMIENDA_FIELD
	 */
	private static final String USUARIO_RECOMIENDA_FIELD = "usuarioRecomienda";
	/**
	 * 3/01/2014
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * USUARIO_FIELD
	 */
	private static final String USUARIO_FIELD = "usuario";

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.recomendacion.UsuarioRecomendacionDao#findRecomendacionesByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<UsuarioRecomendacion> findRecomendacionesByUsuario(
			Usuario usuario) {
		Criterion criterion= Restrictions.eq(USUARIO_FIELD,usuario);
		return findByCriteria(criterion);
	}

	/* (non-Javadoc)
	 * @see co.icesi.troca.repositories.recomendacion.UsuarioRecomendacionDao#findRecomendacionUsuario(co.icesi.troca.model.usuario.Usuario, co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<UsuarioRecomendacion> findRecomendacionUsuario(
			Usuario recomendador, Usuario recomendado) {
		if (recomendador ==null || recomendado == null) {
			return new ArrayList<UsuarioRecomendacion>();
		}
		if (recomendador.getId() ==null || recomendado.getId() == null) {
			return new ArrayList<UsuarioRecomendacion>();
		}
		 Criterion crit = Restrictions.conjunction().add(Restrictions.eq(USUARIO_FIELD, recomendado)).add(Restrictions.eq(USUARIO_RECOMIENDA_FIELD, recomendador));
		return findByCriteria(crit);
	}

}
