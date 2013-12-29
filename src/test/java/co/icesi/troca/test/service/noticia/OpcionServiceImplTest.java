/**
 * 
 */
package co.icesi.troca.test.service.noticia;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.Opcion;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionServiceImplTest
 * @date 6/11/2013
 * 
 */
public class OpcionServiceImplTest extends BaseUnit {

	@Autowired
	private OpcionService opcionService;

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
		return opcionService.save(opcion);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Opcion opcion = saveOpcionTest();
		opcionService.delete(opcion);
		opcion = opcionService.findById(opcion.getKey());
		assertNull(opcion);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Opcion> listado = opcionService.findAll();
		assertNotNull(listado);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Opcion opcion = saveOpcionTest();
		opcion = opcionService.findById(opcion.getKey());
		assertNotNull(opcion);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Opcion opcion = saveOpcionTest();
		opcion = opcionService.findById(opcion.getKey());
		assertNotNull(opcion);
	}

}
