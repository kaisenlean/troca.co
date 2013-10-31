package co.icesi.troca.services.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.UsuarioDao;
import co.icesi.troca.services.UsuarioService;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class UsuarioServiceImpl
* @date 22/10/2013
*
 */
@Service("usuarioService")
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService, Serializable {

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7342021171479215673L;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuarioDAO
	 */
	@Resource(name = "usuarioDao")
	private UsuarioDao usuarioDAO;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param usuarioDAO
	*/
	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Usuario, Integer> getDao() {
		return usuarioDAO;
	}

	@Override
	public Usuario loggedIn(Usuario usuario) {
		return usuarioDAO.loggedIn(usuario);
		
	}

}
