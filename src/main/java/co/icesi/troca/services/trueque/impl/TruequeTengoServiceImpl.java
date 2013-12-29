/**
 * 
 */
package co.icesi.troca.services.trueque.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.trueque.TruequeTengoDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.trueque.TruequeTengoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeTengoServiceImpl
 * @date 2/12/2013
 * 
 */
@Service("truequeTengoService")
public class TruequeTengoServiceImpl extends
		GenericServiceImpl<TruequeTengo, Integer> implements
		TruequeTengoService, Serializable {

	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TruequeTengoDao truequeTengoDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.trueque.TruequeTengoService#findByTengoAndSolicitante(co.icesi.troca.model.tengo.Tengo,
	 *      co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<TruequeTengo> findByTengoAndSolicitante(Tengo tengo,
			Usuario usuario) {
		return truequeTengoDao.findByTengoAndSolicitante(tengo, usuario);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<TruequeTengo, Integer> getDao() {
		return truequeTengoDao;
	}

}
