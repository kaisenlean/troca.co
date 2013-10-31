package co.icesi.troca.repositories.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.UsuarioDao;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioDAOImpl
 * @date 22/10/2013
 * 
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericJpaRepository<Usuario, Integer>
		implements UsuarioDao {
	private static final int MAX_RESULT_ONE = 1;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.UsuarioDao#loggedIn(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public Usuario loggedIn(Usuario usuario) {
		Query q = getEntityManager().createQuery(new StringBuilder("select u from Usuario u where u.email = :idUsuario and u.password = :passwordUsuario").toString());
		q.setParameter("idUsuario", usuario.getEmail());
		q.setParameter("passwordUsuario", usuario.getPassword());
		q.setMaxResults(MAX_RESULT_ONE);
		if (q.getResultList().isEmpty()) {
			return null;
		}else{
			return (Usuario) q.getSingleResult();
			
		}
	}

}
