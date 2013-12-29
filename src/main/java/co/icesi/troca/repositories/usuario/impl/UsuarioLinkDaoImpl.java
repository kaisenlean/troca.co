/**
 * 
 */
package co.icesi.troca.repositories.usuario.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.usuario.UsuarioLinkDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioLinkDaoImpl
 * @date 28/11/2013
 * 
 */
@Repository("usuarioLinkDao")
public class UsuarioLinkDaoImpl extends
		GenericJpaRepository<UsuarioLink, Integer> implements UsuarioLinkDao,
		Serializable {

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         USUARIO_FIELD
	 */
	private static final String USUARIO_FIELD = "usuario";
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.usuario.UsuarioLinkDao#getLinkByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<UsuarioLink> getLinkByUsuario(Usuario usuario) {
		Criterion crit = Restrictions.eq(USUARIO_FIELD, usuario);
		return findByCriteria(crit);
	}

}
