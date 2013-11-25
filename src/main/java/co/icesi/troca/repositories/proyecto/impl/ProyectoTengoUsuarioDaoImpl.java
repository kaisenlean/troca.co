/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
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

}
