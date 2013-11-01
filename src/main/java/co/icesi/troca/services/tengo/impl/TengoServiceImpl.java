/**
 * 
 */
package co.icesi.troca.services.tengo.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.tengo.TengoDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.tengo.TengoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoServiceImpl
 * @date 31/10/2013
 *
 */
@Service("tengoService")
public class TengoServiceImpl extends GenericServiceImpl<Tengo, Integer> implements TengoService,Serializable{

	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TengoDao tengoDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Tengo, Integer> getDao() {
		return tengoDao;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengoDao the tengoDao to set
	 */
	public void setTengoDao(TengoDao tengoDao) {
		this.tengoDao = tengoDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.tengo.TengoService#findTengosByUsuario()
	 */
	@Override
	public List<Tengo> findTengosByUsuario(Usuario usuario) {
		return tengoDao.findTengosByUsuario(usuario);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.tengo.TengoService#findUltimosTengo(int)
	 */
	@Override
	public List<Tengo> findUltimosTengo(int maxResults) {
		return tengoDao.findUltimosTengo(maxResults);
	}
}
