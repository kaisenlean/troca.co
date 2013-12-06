/**
 * 
 */
package co.icesi.troca.services.trueque.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.trueque.TruequeDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.trueque.TruequeService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeServiceImpl
 * @date 2/12/2013
 *
 */
@Service("truequeService")
public class TruequeServiceImpl extends GenericServiceImpl<Trueque, Integer> implements Serializable , TruequeService {

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private TruequeDao truequeDao;
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Trueque, Integer> getDao() {
		return truequeDao;
	}

}
