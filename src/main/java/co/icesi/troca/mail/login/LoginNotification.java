/**
 * 
 */
package co.icesi.troca.mail.login;

import co.icesi.troca.model.usuario.Usuario;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class LoginNotification
 * @date 3/11/2013
 * 
 */
public interface LoginNotification {

	/**
	 * Método que envia un mail al usuario para poder confirmar su cuenta
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/11/2013
	 * @param usuario
	 */
	public void enviarMailAutenticacionCuenta(Usuario usuario) throws Exception;

	
	
}
