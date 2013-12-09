/**
 * 
 */
package co.icesi.troca.repositories.calificacion.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.Calificacion;
import co.icesi.troca.repositories.calificacion.CalificacionDao;
import co.icesi.troca.repositories.impl.GenericJpaRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CalificacionDaoImpl
 * @date 9/12/2013
 *
 */
@Repository("calificacionDao")
public class CalificacionDaoImpl extends GenericJpaRepository<Calificacion, Integer> implements Serializable,CalificacionDao {

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
