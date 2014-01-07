/**
 * 
 */
package co.icesi.troca.mail.login;

import co.icesi.troca.exception.BaseException;
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
	void enviarMailAutenticacionCuenta(Usuario usuario) throws BaseException;

	/**
	 * Método que envia la clave de recuperacion de password
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/01/2014
	 * @param usuario
	 * @throws BaseException
	 */
	void enviarMailRecuperarPassword(Usuario usuario) throws BaseException;

}
