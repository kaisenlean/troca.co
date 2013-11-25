/**
 * 
 */
package co.icesi.troca.services.necesito.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.necesito.CategoriaNecesito;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.necesito.CategoriaNecesitoDao;
import co.icesi.troca.services.GenericService;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.necesito.CategoriaNecesitoService;


/**
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CategoriaNecesitoServiceImpl
* @date 24/11/2013
*
*/
@Service("categoriaNecesitoService")
public class CategoriaNecesitoServiceImpl extends GenericServiceImpl<CategoriaNecesito, Integer> implements Serializable,GenericService<CategoriaNecesito, Integer>,CategoriaNecesitoService{


	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * necesitoDao
	 */
	@Autowired
	private CategoriaNecesitoDao categoriaNecesitoDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<CategoriaNecesito, Integer> getDao() {
		return categoriaNecesitoDao;
	}

	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaNecesitoDao the categoriaNecesitoDao to set
	 */
	public void setCategoriaNecesitoDao(
			CategoriaNecesitoDao categoriaNecesitoDao) {
		this.categoriaNecesitoDao = categoriaNecesitoDao;
	}
	
	
	

}
