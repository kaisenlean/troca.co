/**
 * 
 */
package co.icesi.troca.test.service.usuario;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.impl.UsuarioServiceImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Unidad de tests de la clase {@link UsuarioServiceImpl}
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioServiceImplTest
 * @date 22/10/2013
 * 
 */

public class UsuarioServiceImplTest extends BaseUnit {

	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "******";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioService
	 */
	@Autowired
	private UsuarioService usuarioService;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         logger
	 */
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * test del metodo {@link UsuarioService#loggedIn(Usuario)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	@Test
	public void loggedInTest() {
		Usuario usuario = saveTestUsuario();
		Usuario uTemp = usuarioService.loggedIn(usuario);
		assertNotNull(uTemp);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 * @return
	 */
	private Usuario saveTestUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre(NOMBRE_PRUEBA);
		usuario.setApellido(APELLIDO_PRUEBA);
		usuario.setEmail(EMAIL_PRUEBA);
		usuario.setPassword(PASSWORD_PRUEBA);
		usuario.setBiografia(BIOGRAPHY_PRUEBA);
		Usuario temp = usuarioService.save(usuario);
		return temp;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	@Test
	public void testDelete() {
		Usuario temp = saveTestUsuario();
		assertNotNull(temp);
		usuarioService.delete(temp);
		Usuario ret = usuarioService.findById(temp.getId());
		assertNull(ret);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#findAll()}.
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	@Test
	public void testFindAll() {
		List<Usuario> lista = usuarioService.findAll();
		logger.info(lista);
		assertNotNull(lista);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	@Test
	public void testFindById() {
		Usuario temp = saveTestUsuario();
		assertNotNull(temp);
		Usuario ret = usuarioService.findById(temp.getId());
		assertNotNull(ret);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.impl.GenericServiceImpl#save(java.lang.Object)}
	 * .
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	@Test
	public void testSave() {
		Usuario temp = saveTestUsuario();
		assertNotNull(temp.getId());
	}

}
