package co.icesi.troca.mail;

import java.io.File;

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
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/11/2013
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void send(String to, String subject, String text);

	/**
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

}
