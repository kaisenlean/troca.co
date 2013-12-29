/**
 * 
 */
package co.icesi.troca.test.dao.noticia;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.repositories.noticia.NoticiaDao;
import co.icesi.troca.repositories.noticia.impl.NoticiaDaoImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Test case para la clase {@link NoticiaDaoImpl}
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiaDaoImplTest
 * @date 31/10/2013
 * 
 */

public class NoticiaDaoImplTest extends BaseUnit {

	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ONE_NUMBER
	 */
	private static final int ONE_NUMBER = 1;
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         NATURAL_ZERO
	 */
	private static final int NATURAL_ZERO = 0;
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
	private NoticiaDao noticiaDao;

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	@Test
	public void findNoticiasByFechasTest() {
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.set(Calendar.HOUR, NATURAL_ZERO);
		fechaInicio.set(Calendar.MINUTE, NATURAL_ZERO);
		fechaInicio.set(Calendar.SECOND, NATURAL_ZERO);
		fechaInicio.set(Calendar.MILLISECOND, NATURAL_ZERO);

		Calendar fechaFIn = Calendar.getInstance();
		fechaFIn.add(Calendar.DAY_OF_MONTH,
				fechaInicio.get(Calendar.DAY_OF_MONTH) - ONE_NUMBER);
		fechaFIn.set(Calendar.HOUR, NATURAL_ZERO);
		fechaFIn.set(Calendar.MINUTE, NATURAL_ZERO);
		fechaFIn.set(Calendar.SECOND, NATURAL_ZERO);
		fechaFIn.set(Calendar.MILLISECOND, NATURAL_ZERO);

		List<Noticia> noticias = noticiaDao.findNoticiasByFechas(
				fechaInicio.getTime(), fechaFIn.getTime());

		assertNotNull(noticias);

	}

	/**
	 * Test for method {@link NoticiaDaoImpl#findUltimasNoticias(int)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	@Test
	public void findUltimasNoticias() {
		List<Noticia> ultimasNoticias = noticiaDao.findUltimasNoticias(2);
		assertNotNull(ultimasNoticias);
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
		noticia = noticiaDao.save(noticia);
		return noticia;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param noticiaDao
	 *            the noticiaDao to set
	 */
	public void setNoticiaDao(NoticiaDao noticiaDao) {
		this.noticiaDao = noticiaDao;
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Noticia noticia = saveTestNoticia();
		noticiaDao.delete(noticia);
		noticia = noticiaDao.findById(noticia.getId());
		assertNull(noticia);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Noticia> lista = noticiaDao.findAll();
		assertNotNull(lista);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Noticia noticia = saveTestNoticia();
		Integer id = noticia.getId();
		Noticia nTemp = noticiaDao.findById(id);
		assertNotNull(nTemp);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Noticia noticia = saveTestNoticia();
		assertNotNull(noticia.getId());

	}
}
