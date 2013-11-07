/**
 * 
 */
package co.icesi.troca.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.Opcion;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.OpcionDao;
import co.icesi.troca.services.OpcionService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionServiceImpl
 * @date 6/11/2013
 *
 */
@Service("opcionService")
public class OpcionServiceImpl  extends GenericServiceImpl<Opcion	,String> implements OpcionService,Serializable{

	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OpcionDao opcionDao;
	
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Opcion, String> getDao() {
		return opcionDao;
	}


	/** (non-Javadoc)
	 * @see co.icesi.troca.services.OpcionService#getValueByKey(java.lang.String)
	 */
	@Override
	public String getValueByKey(String key) throws Exception {
		return opcionDao.getValueByKey(key);
	}

}
