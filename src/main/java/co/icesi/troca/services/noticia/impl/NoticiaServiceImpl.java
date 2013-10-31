/**
 * 
 */
package co.icesi.troca.services.noticia.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.noticia.NoticiaDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.noticia.NoticiaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaServiceImpl
 * @date 31/10/2013
 *
 */
@Service("noticiaService")
public class NoticiaServiceImpl extends GenericServiceImpl<Noticia, Integer> implements NoticiaService {

	private static final int NATURAL_ZERO = 0;
	private static final int ONE_NUMBER = 1;
	@Autowired
	private NoticiaDao noticiaDao;
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Noticia, Integer> getDao() {
		return noticiaDao;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param noticiaDao the noticiaDao to set
	 */
	public void setNoticiaDao(NoticiaDao noticiaDao) {
		this.noticiaDao = noticiaDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.noticia.NoticiaService#findUltimasNoticias()
	 */
	@Override
	public List<Noticia> findUltimasNoticias() {
		Calendar fechaInicio= Calendar.getInstance();
		fechaInicio.set(Calendar.HOUR, NATURAL_ZERO);
		fechaInicio.set(Calendar.MINUTE, NATURAL_ZERO);
		fechaInicio.set(Calendar.SECOND, NATURAL_ZERO);
		fechaInicio.set(Calendar.MILLISECOND,NATURAL_ZERO);
		
		Calendar fechaFin = Calendar.getInstance();
		fechaFin.add(Calendar.DAY_OF_MONTH, fechaInicio.get(Calendar.DAY_OF_MONTH)-ONE_NUMBER);
		fechaFin.set(Calendar.HOUR, NATURAL_ZERO);
		fechaFin.set(Calendar.MINUTE, NATURAL_ZERO);
		fechaFin.set(Calendar.SECOND, NATURAL_ZERO);
		fechaFin.set(Calendar.MILLISECOND, NATURAL_ZERO);
		
		
		
		return noticiaDao.findNoticiasByFechas(fechaInicio.getTime(), fechaFin.getTime());
	}

}
