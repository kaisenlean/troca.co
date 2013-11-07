/**
 * 
 */
package co.icesi.troca.services.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.proyecto.ProyectoDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.proyecto.ProyectoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoServiceImpl
 * @date 7/11/2013
 *
 */
@Service("proyectoService")
public class ProyectoServiceImpl extends GenericServiceImpl<Proyecto, Integer> implements ProyectoService ,Serializable{

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoDao proyectoDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Proyecto, Integer> getDao() {
		return proyectoDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.proyecto.ProyectoService#findProyectosByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Proyecto> findProyectosByUsuario(Usuario usuario) {
		return proyectoDao.findProyectosByUsuario(usuario);
	}

}
