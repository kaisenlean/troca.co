/**
 * 
 */
package co.icesi.troca.services.noticia.impl;

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
		return noticiaDao.findUltimasNoticias(2);
	}

}