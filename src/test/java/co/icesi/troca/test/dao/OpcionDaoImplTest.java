/**
 * 
 */
package co.icesi.troca.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.Opcion;
import co.icesi.troca.repositories.OpcionDao;
import co.icesi.troca.repositories.impl.OpcionDaoImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionDaoImplTest
 * @date 6/11/2013
 * 
 */
public class OpcionDaoImplTest extends BaseUnit {

	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         OPCION_DESCRIPCION
	 */
	private static final String OPTION_DESCRIPCION = "DESC";
	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         OPTION_VALUE
	 */
	private static final String OPTION_VALUE = "666VALUE";
	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         OPTION_KEY
	 */
	private static final String OPTION_KEY = "666";
	@Autowired
	private OpcionDao opcionDao;

	/**
	 * Test method for {@link OpcionDaoImpl#getValueByKey(String)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 */
	@Test
	public void getValueByKey() {
		Opcion opcion = saveOpcionTest();
		try {

			String value = opcionDao.getValueByKey(opcion.getKey());

			assertNotNull(value);

		} catch (Exception e) {
			log.error(e.toString());
		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 * @return
	 */
	private Opcion saveOpcionTest() {
		Opcion opcion = new Opcion();
		opcion.setKey(OPTION_KEY);
		opcion.setValue(OPTION_VALUE);
		opcion.setDescripcion(OPTION_DESCRIPCION);
		return opcionDao.save(opcion);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Opcion opcion = saveOpcionTest();
		opcionDao.delete(opcion);

		opcion = opcionDao.findById(opcion.getKey());

		assertNull(opcion);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Opcion> listado = opcionDao.findAll();
		assertNotNull(listado);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Opcion opcion = saveOpcionTest();
		opcion = opcionDao.findById(opcion.getKey());
		assertNotNull(opcion);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Opcion opcion = saveOpcionTest();
		assertNotNull(opcion);
	}

}
