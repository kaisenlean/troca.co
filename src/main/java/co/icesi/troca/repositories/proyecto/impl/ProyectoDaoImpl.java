/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.proyecto.ProyectoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImpl
 * @date 7/11/2013
 *
 */
@Repository("proyectoDao")
public class ProyectoDaoImpl extends GenericJpaRepository<Proyecto, Integer> implements ProyectoDao,Serializable {

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * FIELD_OWNER
	 */
	private static final String FIELD_OWNER = "owner";

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.proyecto.ProyectoDao#findProyectosByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Proyecto> findProyectosByUsuario(Usuario usuario) {
	Criterion criteria= Restrictions.eq(FIELD_OWNER, usuario);
		return findByCriteria(criteria);
	}

}
