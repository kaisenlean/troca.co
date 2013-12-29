/**
 * 
 */
package co.icesi.troca.repositories.trueque.calificacion.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.trueque.TruequeCalificacion;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.calificacion.TruequeCalificacionDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeCalificacionDaoImpl
 * @date 9/12/2013
 * 
 */
@Repository("truequeCalificacionDao")
public class TruequeCalificacionDaoImpl extends
		GenericJpaRepository<TruequeCalificacion, Integer> implements
		Serializable, TruequeCalificacionDao {

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
