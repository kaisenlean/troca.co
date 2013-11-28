package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
		implements UsuarioDao, Serializable {
	/**
	 * 7/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_RESULT_ONE = 1;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.UsuarioDao#loggedIn(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public Usuario loggedIn(Usuario usuario) {
		Query q = getEntityManager()
				.createQuery(
						new StringBuilder(
								"select u from Usuario u where u.email = :idUsuario and u.password = :passwordUsuario")
								.toString());
		q.setParameter("idUsuario", usuario.getEmail());
		q.setParameter("passwordUsuario", usuario.getPassword());
		q.setMaxResults(MAX_RESULT_ONE);
		if (q.getResultList().isEmpty()) {
			return null;
		} else {
			return (Usuario) q.getSingleResult();

		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.UsuarioDao#findUsuariosByParam(java.lang.String)
	 */
	@Override
	public List<Usuario> findUsuariosByParam(String param) {

	Criterion crit=	Restrictions.disjunction()
				.add(Restrictions.like("nombre", param, MatchMode.ANYWHERE))
				.add(Restrictions.like("apellido", param, MatchMode.ANYWHERE))
				.add(Restrictions.like("email", param, MatchMode.ANYWHERE));
		return findByCriteria(crit);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.UsuarioDao#getByNombreApellido(java.lang.String)
	 */
	@Override
	public Usuario getByNombreApellido(String nombre,String apellido) {
		Criterion crit = Restrictions.eq("nombre", nombre);
		Criterion crit2 = Restrictions.eq("apellido", apellido);
		List<Usuario> lista =findByCriteria(crit,crit2);
		if (lista.size()>0) {
			return lista.get(0);
		}else{
			return null;
			
		}
	}
	
	

}
