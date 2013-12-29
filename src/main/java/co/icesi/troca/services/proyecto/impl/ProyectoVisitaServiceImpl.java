/**
 * 
 */
package co.icesi.troca.services.proyecto.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoVisita;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.proyecto.ProyectoVisitaDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.proyecto.ProyectoVisitaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoVisitaServiceImpl
 * @date 8/12/2013
 * 
 */
@Service("proyectoVisitaService")
public class ProyectoVisitaServiceImpl extends
		GenericServiceImpl<ProyectoVisita, Integer> implements Serializable,
		ProyectoVisitaService {

	@Autowired
	private ProyectoVisitaDao proyectoVisitaDao;

	/**
	 * 8/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoVisitaService#findProyectosMasVisitados()
	 */
	@Override
	public List<Proyecto> findProyectosMasVisitados(int maxResults)
			throws BaseException {
		return proyectoVisitaDao.findProyectosMasVisitados(maxResults);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<ProyectoVisita, Integer> getDao() {
		return proyectoVisitaDao;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.proyecto.ProyectoVisitaService#registrarVisita(co.icesi.troca.model.proyecto.Proyecto,
	 *      co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void registrarVisita(Proyecto proyecto, Usuario usuario)
			throws BaseException {
		proyectoVisitaDao.registrarVisita(proyecto, usuario);
	}

}
