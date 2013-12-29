/**
 * 
 */
package co.icesi.troca.test.service.noticia;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.services.noticia.impl.NoticiaServiceImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Test case para la clase {@link NoticiaServiceImpl}
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaServiceImplTest
 * @date 31/10/2013
 * 
 */

public class NoticiaServiceImplTest extends BaseUnit {

	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         INFORMACION_DE_LA_NOTICIA
	 */
	private static final String INFORMACION_DE_LA_NOTICIA = "INFORMACION DE LA NOTICIA";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         TITULO_NOTICIA
	 */
	private static final String TITULO_NOTICIA = "NUEVA NOTICIA";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         LINK_NOTICIA
	 */
	private static final String LINK_NOTICIA = "LINK";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         FOTOGRAFIA_NOTICIA
	 */
	private static final String FOTOGRAFIA_NOTICIA = "NA";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         FECHA_NOTICIA
	 */
	private static final Date FECHA_NOTICIA = new Date();

	@Autowired
	private NoticiaService noticiaService;

	/**
	 * Test method by {@link NoticiaServiceImpl#findUltimasNoticias()}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	@Test
	public void findUltimasNoticiasTest() {
		List<Noticia> noticias = noticiaService.findUltimasNoticias();
		assertNotNull(noticias);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return
	 */
	private Noticia saveTestNoticia() {
		Noticia noticia = new Noticia();
		noticia.setFecha(FECHA_NOTICIA);
		noticia.setFotografia(FOTOGRAFIA_NOTICIA);
		noticia.setLink(LINK_NOTICIA);
		noticia.setTitulo(TITULO_NOTICIA);
		noticia.setNoticia(INFORMACION_DE_LA_NOTICIA);
		noticia = noticiaService.save(noticia);
		return noticia;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param noticiaService
	 *            the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Noticia noticia = saveTestNoticia();
		noticiaService.delete(noticia);
		noticia = noticiaService.findById(noticia.getId());
		assertNull(noticia);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Noticia> lista = noticiaService.findAll();
		assertNotNull(lista);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Noticia noticia = saveTestNoticia();
		Integer id = noticia.getId();
		Noticia nTemp = noticiaService.findById(id);
		assertNotNull(nTemp);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Noticia noticia = saveTestNoticia();
		assertNotNull(noticia.getId());
	}

}
