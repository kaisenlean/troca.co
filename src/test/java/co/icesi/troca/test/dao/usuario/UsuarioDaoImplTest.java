package co.icesi.troca.test.dao.usuario;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.UsuarioDao;
import co.icesi.troca.repositories.impl.UsuarioDaoImpl;

/**
 * Unidad de test de la clase {@link UsuarioDaoImpl}
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class UsuarioDaoImplTest
* @date 22/10/2013
*
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class UsuarioDaoImplTest  {

	

	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "666";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";
	
	@Autowired
	private UsuarioDao dao;

	private Logger logger = Logger.getLogger(getClass());
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testCreate() {
		Usuario temp = saveTestUsuario();
		assertNotNull(temp.getId());
	}

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testFindAll() {
		List<Usuario> lista = dao.findAll();
		logger.info(lista);
		assertNotNull(lista);

	}
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testDelete() {
		Usuario temp = saveTestUsuario();
		assertNotNull(temp);
		dao.delete(temp);
		Usuario ret = dao.findById(temp.getId());
		assertNull(ret);
	}
/**
 * 
* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @date 31/10/2013
* @param dao
 */
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	/**
	 * 
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
		Usuario temp = dao.save(usuario);
		return temp;
	}
	/**
	 * Test del metodo de validacion de usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void loggedInTest(){
		Usuario usuario= saveTestUsuario();
		Usuario uTemp= dao.loggedIn(usuario);
		logger.info(uTemp);
		assertNotNull(uTemp);
		
	}
}
