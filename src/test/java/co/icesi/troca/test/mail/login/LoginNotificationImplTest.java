/**
 * 
 */
package co.icesi.troca.test.mail.login;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class LoginNotificationImplTest
 * @date 3/11/2013
 *
 */
public class LoginNotificationImplTest extends BaseUnit {

	@Autowired
	private LoginNotification loginNotification;
	/**
	 * Test method for {@link co.icesi.troca.mail.login.impl.LoginNotificationImpl#enviarMailAutenticacionCuenta(co.icesi.troca.model.usuario.Usuario)}.
	 */
	@Test
	public void testEnviarMailAutenticacionCuenta() {
		Usuario usuario= new Usuario();
		usuario.setEmail("elmerdiazlazo@gmail.com");
		usuario.setNombre("Usuario");
		usuario.setApellido("De Test");
		loginNotification.enviarMailAutenticacionCuenta(usuario);
	}

}
