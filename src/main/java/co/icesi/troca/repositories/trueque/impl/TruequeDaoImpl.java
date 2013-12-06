/**
 * 
 */
package co.icesi.troca.repositories.trueque.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.TruequeDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeDaoImpl
 * @date 2/12/2013
 *
 */
@Repository("truequeDao")
public class TruequeDaoImpl extends GenericJpaRepository<Trueque, Integer> implements TruequeDao , Serializable {

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
