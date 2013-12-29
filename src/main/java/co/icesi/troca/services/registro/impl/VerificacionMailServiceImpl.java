/**
 * 
 */
package co.icesi.troca.services.registro.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.exception.BaseException;
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

	private Logger logVerificacionMail = LoggerFactory
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
	 * @see co.icesi.troca.services.registro.VerificationMailService#crearClaveVerificacion(java.lang.String)
	 */
	@Override
	public String crearClaveVerificacion(Usuario usuario) throws BaseException {

		if (usuario == null) {
			throw new BaseException(USUARIO_ES_NULO_MSG);
		}

		if (usuario.getEmail() == null | usuario.getEmail().isEmpty()) {
			throw new BaseException(EMAIL_INVALIDO_MSG);
		}

		return encoderManager.encodeMd5Hash(usuario.getEmail());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.registro.VerificationMailService#enviarMailVerificacion(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void enviarMailVerificacion(Usuario usuario) throws BaseException {

		String hashKey = crearClaveVerificacion(usuario);
		usuario.setClaveVerificacion(hashKey);
		loginNotification.enviarMailAutenticacionCuenta(usuario);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return the lOGGER
	 */
	public Logger getLogger() {
		return logVerificacionMail;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/12/2013
	 * @return the logVerificacionMail
	 */
	public Logger getLogVerificacionMail() {
		return logVerificacionMail;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param lOGGER
	 *            the lOGGER to set
	 */
	public void setLogger(Logger logger) {
		logVerificacionMail = logger;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/12/2013
	 * @param logVerificacionMail
	 *            the logVerificacionMail to set
	 */
	public void setLogVerificacionMail(Logger logVerificacionMail) {
		this.logVerificacionMail = logVerificacionMail;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.registro.VerificationMailService#verificarMailUsuario(java.lang.String)
	 */
	@Override
	public boolean verificarMailUsuario(String mailKey) throws BaseException {

		return false;
	}
}
