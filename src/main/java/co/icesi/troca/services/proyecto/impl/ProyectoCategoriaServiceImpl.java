/**
 * 
 */
package co.icesi.troca.services.proyecto.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.proyecto.ProyectoCategoria;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.proyecto.ProyectoCategoriaDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.proyecto.ProyectoCategoriaService;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class ProyectoCategoriaServiceImpl
* @date 24/11/2013
*
 */
@Service("proyectoCategoriaService")
public class ProyectoCategoriaServiceImpl extends GenericServiceImpl<ProyectoCategoria, Integer> implements ProyectoCategoriaService ,Serializable{

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoCategoriaDao proyectoDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<ProyectoCategoria, Integer> getDao() {
		return proyectoDao;
	}

	

}
