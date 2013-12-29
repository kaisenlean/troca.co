/**
 * 
 */
package co.icesi.troca.services.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.proyecto.ProyectoTengoUsuarioDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImpl
 * @date 7/11/2013
 * 
 */
@Service("proyectoTengoUsuarioService")
public class ProyectoTengoUsuarioServiceImpl extends
		GenericServiceImpl<ProyectoTengoUsuario, Integer> implements
		ProyectoTengoUsuarioService, Serializable {

	/**
	 * 7/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProyectoTengoUsuarioDao proyectoTengoUsuarioDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService#findTengosByProyecto(co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public List<ProyectoTengoUsuario> findTengosByProyecto(Proyecto proyecto) {
		return proyectoTengoUsuarioDao.findTengosByProyecto(proyecto);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService#getByTengoAndProyecto(co.icesi.troca.model.proyecto.Proyecto,
	 *      co.icesi.troca.model.tengo.Tengo)
	 */
	@Override
	public ProyectoTengoUsuario getByTengoAndProyecto(Proyecto proyecto,
			Tengo tengo) {
		return proyectoTengoUsuarioDao.getByTengoAndProyecto(proyecto, tengo);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<ProyectoTengoUsuario, Integer> getDao() {
		return proyectoTengoUsuarioDao;
	}

}
