/**
 * 
 */
package co.icesi.troca.services.recomendacion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioRecomendacion;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.recomendacion.UsuarioRecomendacionDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.recomendacion.UsuarioRecomendacionService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioRecomendacionServiceImpl
 * @date 2/01/2014
 *
 */
@Service("usuarioRecomendacionService")
public class UsuarioRecomendacionServiceImpl  extends GenericServiceImpl<UsuarioRecomendacion, Integer> implements UsuarioRecomendacionService{

	@Autowired
	private UsuarioRecomendacionDao usuarioRecomendacionDao;
	
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<UsuarioRecomendacion, Integer> getDao() {
		return usuarioRecomendacionDao;
	}


	/** (non-Javadoc)
	 * @see co.icesi.troca.services.recomendacion.UsuarioRecomendacionService#findRecomendacionesByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<UsuarioRecomendacion> findRecomendacionesByUsuario(
			Usuario usuario) {
		return usuarioRecomendacionDao.findRecomendacionesByUsuario(usuario);
	}


	/** (non-Javadoc)
	 * @see co.icesi.troca.services.recomendacion.UsuarioRecomendacionService#findRecomendacionUsuario(co.icesi.troca.model.usuario.Usuario, co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<UsuarioRecomendacion> findRecomendacionUsuario(
			Usuario recomendador, Usuario recomendado) {
return usuarioRecomendacionDao.findRecomendacionUsuario(recomendador, recomendado);
	}

}
