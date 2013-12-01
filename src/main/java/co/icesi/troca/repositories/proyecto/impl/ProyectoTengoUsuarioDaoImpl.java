/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.proyecto.ProyectoTengoUsuarioDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImpl
 * @date 7/11/2013
 *
 */
@Repository("proyectoTengoUsuarioDao")
public class ProyectoTengoUsuarioDaoImpl extends GenericJpaRepository<ProyectoTengoUsuario, Integer> implements ProyectoTengoUsuarioDao,Serializable {

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoTengoUsuarioDao#findTengosByProyecto(co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public List<ProyectoTengoUsuario> findTengosByProyecto(Proyecto proyecto) {
		Criterion criterion = Restrictions.eq("proyecto", proyecto);
		return findByCriteria(criterion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoTengoUsuarioDao#getByTengoAndProyecto(co.icesi.troca.model.proyecto.Proyecto, co.icesi.troca.model.tengo.Tengo)
	 */
	@Override
	public ProyectoTengoUsuario getByTengoAndProyecto(Proyecto proyecto,
			Tengo tengo) {
		Criterion criterion=Restrictions.conjunction().add(Restrictions.eq("proyecto", proyecto)).add(Restrictions.eq("tengo", tengo));
		
		List<ProyectoTengoUsuario> lista = findByCriteria(criterion);
		if (lista.isEmpty()) {
			return null;
		}else{
			
			return lista.get(BigInteger.ZERO.intValue());
		}
	}

}
