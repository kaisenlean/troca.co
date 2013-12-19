/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoUsuarioDao
 * @date 1/12/2013
 *
 */
@Repository("proyectoUsuarioDao")
public class ProyectoUsuarioDaoImpl  extends GenericJpaRepository<ProyectoUsuario, Integer>  implements co.icesi.troca.repositories.proyecto.ProyectoUsuarioDao ,Serializable{

	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoUsuarioDao#getByUsuarioAndProyecto(co.icesi.troca.model.usuario.Usuario, co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public ProyectoUsuario getByUsuarioAndProyecto(Usuario usuario,
			Proyecto proyecto) {
		Criterion ct1= Restrictions.conjunction().add(Restrictions.eq("usuario", usuario)).add(Restrictions.eq("proyecto", proyecto));
		
		List<ProyectoUsuario> lista= findByCriteria(ct1);
		if (lista.isEmpty()) {
			return null;
		}else{
			return lista.get(BigInteger.ZERO.intValue());
		}
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoUsuarioDao#findByProyecto(co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public List<ProyectoUsuario> findByProyecto(Proyecto proyecto) {
		Criterion criterion= Restrictions.eq("proyecto", proyecto);
		
		return findByCriteria(criterion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoUsuarioDao#findByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> findByUsuario(Usuario usuario) {
		Query query=getEntityManager().createQuery("select p.proyecto from ProyectoUsuario p where p.usuario = :usuario");
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}

}
