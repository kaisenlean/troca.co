/**
 * 
 */
package co.icesi.troca.repositories.tengo.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.tengo.TengoDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoDaoImpl
 * @date 31/10/2013
 *
 */
@Repository("tengoDao")
public class TengoDaoImpl extends GenericJpaRepository<Tengo, Integer> implements TengoDao,Serializable {

	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
