/**
 * 
 */
package co.icesi.troca.test.dao.necesito;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.repositories.necesito.NecesitoDao;
import co.icesi.troca.repositories.necesito.impl.NecesitoDaoImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoDaoImpl
 * @date 20/11/2013
 * 
 */
public class NecesitoDaoImplTest extends BaseUnit {

	/**
	 * 20/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         FECHA_CREACION
	 */
	private static final Date FECHA_CREACION = new Date();
	/**
	 * 20/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         NECESITO_DESCRIPCION
	 */
	private static final String NECESITO_DESCRIPCION = "descripcion desc";
	/**
	 * 20/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         NECESITO_NOMBRE
	 */
	private static final String NECESITO_NOMBRE = "necesito necesito";

	/**
	 * 20/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         necesitoDao
	 */
	@Autowired
	private NecesitoDao necesitoDao;

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Necesito> lista = necesitoDao.findAll();
		assertNotNull(lista);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Necesito necesito = testCreateNecesito();
		Integer id = necesito.getId();

		necesito = necesitoDao.findById(id);
		assertNotNull(necesito);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 20/11/2013
	 * @return
	 */
	private Necesito testCreateNecesito() {

		Necesito necesito = new Necesito();
		necesito.setFechaCreacion(FECHA_CREACION);
		necesito.setNombre(NECESITO_NOMBRE);
		necesito.setDescripcion(NECESITO_DESCRIPCION);
		return necesitoDao.save(necesito);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Necesito necesito = testCreateNecesito();
		Integer id = necesito.getId();
		necesitoDao.delete(necesito);
		necesito = necesitoDao.findById(id);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Necesito necesito = testCreateNecesito();
		assertNotNull(necesito.getId());
	}

	/**
	 * Test Method for {@link NecesitoDaoImpl#findUltimosNecesito(int)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 */
	@Test
	public void findUltimosNecesito() {
		List<Necesito> lista= necesitoDao.findUltimosNecesito(3);
		assertNotNull(lista);
		log.debug(String.valueOf(lista.size()));
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 20/11/2013
	 * @param necesitoDao
	 *            the necesitoDao to set
	 */
	public void setNecesitoDao(NecesitoDao necesitoDao) {
		this.necesitoDao = necesitoDao;
	}
}
