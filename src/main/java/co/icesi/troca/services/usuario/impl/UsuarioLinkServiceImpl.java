/**
 * 
 */
package co.icesi.troca.services.usuario.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.usuario.UsuarioLinkDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.usuario.UsuarioLinkService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioLinkServiceImpl
 * @date 28/11/2013
 *
 */
@Service("usuarioLinkService")
public class UsuarioLinkServiceImpl extends GenericServiceImpl<UsuarioLink, Integer>implements UsuarioLinkService,Serializable {

	/**
	 * 28/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private UsuarioLinkDao usuarioLinkDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<UsuarioLink, Integer> getDao() {
		return usuarioLinkDao;
	}

}
