/**
 * 
 */
package co.icesi.troca.repositories.trueque.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.TruequeMensajeDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeMensajeDaoImpl
 * @date 2/12/2013
 *
 */
@Repository("truequeMensajeDao")
public class TruequeMensajeDaoImpl extends GenericJpaRepository<TruequeMensaje, Integer> implements TruequeMensajeDao , Serializable{

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
