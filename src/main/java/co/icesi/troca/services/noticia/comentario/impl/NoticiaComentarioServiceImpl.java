/**
 * 
 */
package co.icesi.troca.services.noticia.comentario.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.noticia.comentario.NoticiaComentarioDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.noticia.comentario.NoticiaComentarioService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaComentarioServiceImpl
 * @date 9/12/2013
 *
 */
@Service("noticiaComentarioService")
public class NoticiaComentarioServiceImpl extends GenericServiceImpl<NoticiaComentario, Integer>implements Serializable,NoticiaComentarioService {

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private NoticiaComentarioDao noticiaComentarioDao;
	
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<NoticiaComentario, Integer> getDao() {
		return noticiaComentarioDao;
	}
	/** (non-Javadoc)
	 * @see co.icesi.troca.services.noticia.comentario.NoticiaComentarioService#findComentariosByNoticia(co.icesi.troca.model.noticia.Noticia)
	 */
	@Override
	public List<NoticiaComentario> findComentariosByNoticia(Noticia noticia) {
		return noticiaComentarioDao.findComentariosByNoticia(noticia);
	}

}
