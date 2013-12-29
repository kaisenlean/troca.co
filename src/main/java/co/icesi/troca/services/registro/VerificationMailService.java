/**
 * 
 */
package co.icesi.troca.services.registro;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.usuario.Usuario;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class VerificationMailService
 * @date 5/11/2013
 * 
 */
public interface VerificationMailService {

	/**
	 * Método que genera un hashkey para la validacion por mail de la creacion
	 * del usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 5/11/2013
	 * @param usuario
	 * @return {@link String}
	 */
	String crearClaveVerificacion(Usuario usuario) throws BaseException;

	/**
	 * Método que envia al usuario la cave de verificaion a su correo
	 * electrónico
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 * @param usuario
	 */
	void enviarMailVerificacion(Usuario usuario) throws BaseException;

	/**
	 * Método que verifica que el hashkey generado coincide con algun mail y
	 * cambia el estado el usuario a activo
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 5/11/2013
	 * @param mailKey
	 * @return
	 */
	boolean verificarMailUsuario(String mailKey) throws BaseException;

}
