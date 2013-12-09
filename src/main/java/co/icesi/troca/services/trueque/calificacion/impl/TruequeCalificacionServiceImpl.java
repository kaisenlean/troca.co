/**
 * 
 */
package co.icesi.troca.services.trueque.calificacion.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.trueque.TruequeCalificacion;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.trueque.calificacion.TruequeCalificacionDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.trueque.calificacion.TruequeCalificacionService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TruequeCalificacionServiceImpl
 * @date 9/12/2013
 *
 */
@Service("truequeCalificacionService")
public class TruequeCalificacionServiceImpl  extends GenericServiceImpl<TruequeCalificacion, Integer> implements Serializable,TruequeCalificacionService{

	
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TruequeCalificacionDao truequeCalificacionDao;
	/* (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<TruequeCalificacion, Integer> getDao() {
		return truequeCalificacionDao;
	}

}
