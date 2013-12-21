/**
 * 
 */
package co.icesi.troca.services.calificacion.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.calificacion.CalificacionDao;
import co.icesi.troca.services.calificacion.CalificacionService;
import co.icesi.troca.services.impl.GenericServiceImpl;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CalificacionServiceImpl
 * @date 9/12/2013
 *
 */
@Service("calificacionService")
public class CalificacionServiceImpl  extends GenericServiceImpl<Calificacion, Integer> implements Serializable , CalificacionService{

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private CalificacionDao calificacionDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Calificacion, Integer> getDao() {
		return calificacionDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.calificacion.CalificacionService#findCalificacionByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Calificacion> findCalificacionByUsuario(Usuario usuario) {
		return calificacionDao.findCalificacionByUsuario(usuario);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.calificacion.CalificacionService#findCalificacionByTruequeCanceladoByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Calificacion> findCalificacionByTruequeCanceladoByUsuario(
			Usuario usuario) {
		return calificacionDao.findCalificacionByTruequeCanceladoByUsuario(usuario);
	}

}
