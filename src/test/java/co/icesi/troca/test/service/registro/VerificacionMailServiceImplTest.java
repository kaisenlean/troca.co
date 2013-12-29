/**
 * 
 */
package co.icesi.troca.test.service.registro;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.registro.VerificationMailService;
import co.icesi.troca.services.registro.impl.VerificacionMailServiceImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Unidad de tests para la clase {@link VerificacionMailServiceImpl}
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class VerificacionMailServiceImplTest
 * @date 6/11/2013
 * 
 */
public class VerificacionMailServiceImplTest extends BaseUnit {

	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         EMAIL_USUARIO
	 */
	private static final String EMAIL_USUARIO = "prueba@troca.co";
	@Autowired
	private VerificationMailService verificationMailService;

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.registro.impl.VerificacionMailServiceImpl#crearClaveVerificacion(co.icesi.troca.model.usuario.Usuario)}
	 * .
	 */
	@Test
	public void testCrearClaveVerificacion() {
		try {

			Usuario usuario = new Usuario();
			usuario.setEmail(EMAIL_USUARIO);

			String salida = verificationMailService
					.crearClaveVerificacion(usuario);
			assertNotNull(salida);
		} catch (Exception e) {
			log.error(e.toString());
		}

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.services.registro.impl.VerificacionMailServiceImpl#verificarMailUsuario(java.lang.String)}
	 * .
	 */
	@Test
	public void testVerificarMailUsuario() {
	}

}
