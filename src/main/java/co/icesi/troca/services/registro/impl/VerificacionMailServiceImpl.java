/**
 * 
 */
package co.icesi.troca.services.registro.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.registro.VerificationMailService;
import co.icesi.troca.services.seguridad.EncoderManager;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class VerificacionMailServiceImpl
 * @date 5/11/2013
 */

@Service("verificacionMailService")
public class VerificacionMailServiceImpl implements VerificationMailService {

	
	
	public static Logger LOGGER = LoggerFactory
			.getLogger(VerificacionMailServiceImpl.class);
	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         EMAIL_INVALIDO_MSG
	 */
	private static final String EMAIL_INVALIDO_MSG = "Falta un email válido";
	/**
	 * 6/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         USUARIO_ES_NULO_MSG
	 */
	private static final String USUARIO_ES_NULO_MSG = "Usuario es nulo";

	@Autowired
	private EncoderManager encoderManager;

	@Autowired
	private LoginNotification loginNotification;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.registro.VerificationMailService#verificarMailUsuario(java.lang.String)
	 */
	@Override
	public boolean verificarMailUsuario(String mailKey) throws Exception {

		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.registro.VerificationMailService#crearClaveVerificacion(java.lang.String)
	 */
	@Override
	public String crearClaveVerificacion(Usuario usuario) throws Exception {

		if (usuario == null) {
			throw new Exception(USUARIO_ES_NULO_MSG);
		}

		if (usuario.getEmail() == null | usuario.getEmail().isEmpty()) {
			throw new Exception(EMAIL_INVALIDO_MSG);
		}

		return encoderManager.encodeMd5Hash(usuario.getEmail());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.registro.VerificationMailService#enviarMailVerificacion(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void enviarMailVerificacion(Usuario usuario) throws Exception {


		String hashKey = crearClaveVerificacion(usuario);
		usuario.setClaveVerificacion(hashKey);
		loginNotification.enviarMailAutenticacionCuenta(usuario);
	}

}
