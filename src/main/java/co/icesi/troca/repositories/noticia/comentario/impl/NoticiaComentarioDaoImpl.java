/**
 * 
 */
package co.icesi.troca.repositories.noticia.comentario.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.noticia.comentario.NoticiaComentarioDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaComentarioImpl
 * @date 9/12/2013
 *
 */
@Repository("noticiaComentarioDao")
public class NoticiaComentarioDaoImpl extends GenericJpaRepository<NoticiaComentario, Integer> implements Serializable, NoticiaComentarioDao {

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.noticia.comentario.NoticiaComentarioDao#findComentariosByNoticia(co.icesi.troca.model.noticia.Noticia)
	 */
	@Override
	public List<NoticiaComentario> findComentariosByNoticia(Noticia noticia) {
		Criterion criterion=Restrictions.eq("noticia", noticia);
		return findByCriteria(criterion);
	}

}
