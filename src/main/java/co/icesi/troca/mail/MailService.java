package co.icesi.troca.mail;

import java.io.File;
import java.util.Map;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class MailService
 * @date 3/11/2013
 * 
 */
public interface MailService {

	/**
	 * Enviar un mail simple
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/11/2013
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void send(String to, String subject, String text);

	/**
	 * En viar un mail con archivos adjuntos
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/11/2013
	 * @param to
	 * @param subject
	 * @param text
	 * @param attachments
	 */
	public void send(String to, String subject, String text,
			File... attachments);

	/**
	 * Enviar un mail simple con una plantilla de velocity
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/11/2013
	 * @param to
	 * @param subject
	 * @param template
	 * @param hTemplateVariables
	 */
	public void send(String to, String subject, String template,
			Map<String, Object> hTemplateVariables);

	

}
