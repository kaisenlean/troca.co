/**
 * 
 */
package co.icesi.troca.services.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.proyecto.ProyectoUsuarioDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.proyecto.ProyectoUsuarioService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoUsuario
 * @date 1/12/2013
 * 
 */
@Service("proyectoUsuarioService")
public class ProyectoUsuarioServiceImpl extends
		GenericServiceImpl<ProyectoUsuario, Integer> implements
		ProyectoUsuarioService, Serializable {

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProyectoUsuarioDao proyectoUsuarioDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoUsuarioService#findByProyecto(co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public List<ProyectoUsuario> findByProyecto(Proyecto proyecto) {
		return proyectoUsuarioDao.findByProyecto(proyecto);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoUsuarioService#findByUsuario(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public List<Proyecto> findByUsuario(Usuario usuario) {
		return proyectoUsuarioDao.findByUsuario(usuario);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoUsuarioService#getByUsuarioAndProyecto(co.icesi.troca.model.usuario.Usuario,
	 *      co.icesi.troca.model.proyecto.Proyecto)
	 */
	@Override
	public ProyectoUsuario getByUsuarioAndProyecto(Usuario usuario,
			Proyecto proyecto) {
		return proyectoUsuarioDao.getByUsuarioAndProyecto(usuario, proyecto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<ProyectoUsuario, Integer> getDao() {
		return proyectoUsuarioDao;
	}

}
