/**
 * 
 */
package co.icesi.troca.mail.login.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.mail.MailService;
import co.icesi.troca.mail.constants.VelocityTemplates;
import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.usuario.Usuario;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class LoginNotificationImpl
 * @date 3/11/2013
 * 
 */
@Service("loginNotification")
public class LoginNotificationImpl implements LoginNotification {

	@Autowired
	private MailService mailService;
	
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.mail.login.LoginNotification#enviarMailAutenticacionCuenta(co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void enviarMailAutenticacionCuenta(Usuario usuario) {
		 HashMap<String, Object> mapa = new HashMap<String, Object>();
		 mapa.put("usuario", usuario.toString());
		 
		
		mailService.send(usuario.getEmail(), "Confirmación de Correo Electrónico (Troca.co)", VelocityTemplates.LOGIN_VERIFICATION_TEMPLATE, mapa);
	}

}
