/**
 * 
 */
package co.icesi.troca.services.necesito.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.necesito.NecesitoDao;
import co.icesi.troca.services.GenericService;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.necesito.NecesitoService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoServiceImpl
 * @date 17/11/2013
 *
 */
@Service("necesitoService")
public class NecesitoServiceImpl extends GenericServiceImpl<Necesito, Integer> implements Serializable,GenericService<Necesito, Integer>,NecesitoService{

	/**
	 * 17/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private NecesitoDao necesitoDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Necesito, Integer> getDao() {
		return necesitoDao;
	}

	
/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 20/11/2013
 * @param necesitoDao the necesitoDao to set
 */
public void setNecesitoDao(NecesitoDao necesitoDao) {
	this.necesitoDao = necesitoDao;
}


/** (non-Javadoc)
 * @see co.icesi.troca.services.necesito.NecesitoService#findUltimosNecesito()
 */
@Override
public List<Necesito> findUltimosNecesito() {
	return necesitoDao.findUltimosNecesito(2);
}


/** (non-Javadoc)
 * @see co.icesi.troca.services.necesito.NecesitoService#findNecesitoByProyecto(co.icesi.troca.model.proyecto.Proyecto)
 */
@Override
public List<Necesito> findNecesitoByProyecto(Proyecto proyecto) {
	return necesitoDao.findNecesitoByProyecto(proyecto);
}


/** (non-Javadoc)
 * @see co.icesi.troca.services.necesito.NecesitoService#findNecesitoByParam(java.lang.String)
 */
@Override
public List<Necesito> findNecesitoByParam(String param) {
	return necesitoDao.findNecesitoByParam(param);
}


/** (non-Javadoc)
 * @see co.icesi.troca.services.necesito.NecesitoService#findUltimosNecesito(int)
 */
@Override
public List<Necesito> findUltimosNecesito(int maxResults) {
	return necesitoDao.findUltimosNecesito(maxResults);
}
}
