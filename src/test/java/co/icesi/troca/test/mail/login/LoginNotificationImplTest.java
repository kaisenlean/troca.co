/**
 * 
 */
package co.icesi.troca.test.mail.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.usuario.Usuario;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class LoginNotificationImplTest
 * @date 3/11/2013
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
public class LoginNotificationImplTest {

	private static Logger LOGGER = LoggerFactory
			.getLogger(LoginNotificationImplTest.class);
	@Autowired
	private LoginNotification loginNotification;

	/**
	 * Test method for
	 * {@link co.icesi.troca.mail.login.impl.LoginNotificationImpl#enviarMailAutenticacionCuenta(co.icesi.troca.model.usuario.Usuario)}
	 * .
	 */
	@Test
	public void testEnviarMailAutenticacionCuenta() {
		Usuario usuario = new Usuario();
		usuario.setEmail("elmerdiazlazo@gmail.com");
		usuario.setNombre("Usuario");
		usuario.setApellido("De Test");
		try {

			loginNotification.enviarMailAutenticacionCuenta(usuario);
		} catch (Exception e) {

			LOGGER.error(e.toString());
		}
	}

}
