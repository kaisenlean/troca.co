/**
 * 
 */
package co.icesi.troca.mail.login.impl;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.mail.MailService;
import co.icesi.troca.mail.constants.VelocityTemplates;
import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.constants.OpcionConstants;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.services.registro.VerificationMailService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class LoginNotificationImpl
 * @date 3/11/2013
 * 
 */
@Service("loginNotification")
public class LoginNotificationImpl implements LoginNotification ,Serializable{

	/**
	 * 13/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * URL_KEY
	 */
	private static final String URL_KEY = "urlHost";

	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * USUARIO_KEY
	 */
	private static final String USUARIO_KEY = "usuario";

	@Autowired
	private MailService mailService;
	
	@Autowired
	private OpcionService opcionService;
	
	@Autowired
	private VerificationMailService verificationMailService;
	
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.mail.login.LoginNotification#enviarMailAutenticacionCuenta(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void enviarMailAutenticacionCuenta(Usuario usuario)throws Exception {
		 HashMap<String, Object> mapa = new HashMap<String, Object>();
		 mapa.put(USUARIO_KEY, usuario.toString());
		 StringBuilder url= new  StringBuilder();
		 url.append(opcionService.getValueByKey(OpcionConstants.HOST_CONTEXT_PATH));
		 url.append(opcionService.getValueByKey(OpcionConstants.KEY_CONTEXT_PATH));
		 url.append("/validate.jsf;userId=");
		 usuario.setClaveVerificacion(verificationMailService.crearClaveVerificacion(usuario));
		 url.append(usuario.getClaveVerificacion());
		 mapa.put(URL_KEY, url.toString());
		 
		mailService.send(usuario.getEmail(), "Confirmación de Correo Electrónico (Troca.co)", VelocityTemplates.LOGIN_VERIFICATION_TEMPLATE, mapa);
		
		
	}

}
