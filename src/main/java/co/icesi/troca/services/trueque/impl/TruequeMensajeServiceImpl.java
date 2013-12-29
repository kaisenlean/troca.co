/**
 * 
 */
package co.icesi.troca.services.trueque.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.trueque.TruequeMensajeDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.trueque.TruequeMensajeService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeMensajeServiceImpl
 * @date 2/12/2013
 * 
 */
@Service("truequeMensajeService")
public class TruequeMensajeServiceImpl extends
		GenericServiceImpl<TruequeMensaje, Integer> implements
		TruequeMensajeService, Serializable {

	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TruequeMensajeDao truequeMensajeDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.trueque.TruequeMensajeService#findMensajesByTrueque(co.icesi.troca.model.trueque.Trueque)
	 */
	@Override
	public List<TruequeMensaje> findMensajesByTrueque(Trueque trueque) {
		return truequeMensajeDao.findMensajesByTrueque(trueque);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<TruequeMensaje, Integer> getDao() {
		return truequeMensajeDao;
	}

}
