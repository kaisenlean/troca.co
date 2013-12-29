/**
 * 
 */
package co.icesi.troca.test.service.necesito;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.services.necesito.NecesitoService;
import co.icesi.troca.services.necesito.impl.NecesitoServiceImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NecesitoDaoImpl
 * @date 20/11/2013
 * 
 */
public class NecesitoServiceImplTest extends BaseUnit {

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
	private NecesitoService necesitoService;

	/**
	 * Test method for {@link NecesitoServiceImpl#findUltimosNecesito()}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/11/2013
	 */
	@Test
	public void findUltimosNecesito() {
		List<Necesito> lista = necesitoService.findUltimosNecesito();
		assertNotNull(lista);
		log.info(String.valueOf(lista.size()));

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
		return necesitoService.save(necesito);

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
		necesitoService.delete(necesito);
		necesito = necesitoService.findById(id);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Necesito> lista = necesitoService.findAll();
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

		necesito = necesitoService.findById(id);
		assertNotNull(necesito);

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
}
