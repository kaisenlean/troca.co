/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.proyecto.ProyectoCategoria;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.proyecto.ProyectoCategoriaDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImpl
 * @date 7/11/2013
 * 
 */
@Repository("proyectoCategoriaDao")
public class ProyectoCategoriaDaoImpl extends
		GenericJpaRepository<ProyectoCategoria, Integer> implements
		ProyectoCategoriaDao, Serializable {

	/**
	 * 7/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
