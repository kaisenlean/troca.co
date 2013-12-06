/**
 * 
 */
package co.icesi.troca.repositories.trueque.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.trueque.TruequeTengoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeTengoDaoImpl
 * @date 2/12/2013
 *
 */
@Repository("truequeTengoDao")
public class TruequeTengoDaoImpl  extends GenericJpaRepository<TruequeTengo, Integer> implements TruequeTengoDao,Serializable{

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
