package co.icesi.troca.mail.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

import co.icesi.troca.mail.MailService;

/**
 * Servicio de envio de mails
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class MailServiceImpl
 * @date 3/11/2013
 * 
 */
@Service("mailService")
public class MailServiceImpl implements MailService ,Serializable{

	/**
	 * 23/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 5/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * VELOCITY_PATH
	 */
	private static final String VELOCITY_PATH = "velocity/";

	/**
	 * 3/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         VELOCITY_EXTENSION
	 */
	private static final String VELOCITY_EXTENSION = ".vm";

	/**
	 * 3/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         PATH_RELATIVE
	 */
	private static final String PATH_RELATIVE = "/src/main/resources/velocity/";

	/**
	 * 3/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         USER_DIR
	 */
	private static final String USER_DIR = "user.dir";

	private static final Log log = LogFactory.getLog(MailServiceImpl.class);

	/** wrapper de Spring sobre javax.mail */
	private JavaMailSenderImpl mailSender;

	
	private  String basePath = new StrBuilder(System.getProperty(USER_DIR)
			.toString()).append(PATH_RELATIVE).toString();

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	private VelocityEngine velocityEngine;

	
	

	/** correo electrónico del remitente */
	private String from;

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return from;
	}

	/** flag para indicar si está activo el servicio */
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private static final File[] NO_ATTACHMENTS = null;

	/**
	 * envío de email
	 * 
	 * @param to
	 *            correo electrónico del destinatario
	 * @param subject
	 *            asunto del mensaje
	 * @param text
	 *            cuerpo del mensaje
	 */
	public void send(String to, String subject, String text) {
		send(to, subject, text, NO_ATTACHMENTS);
	}

	/**
	 * envío de email con attachments
	 * 
	 * @param to
	 *            correo electrónico del destinatario
	 * @param subject
	 *            asunto del mensaje
	 * @param text
	 *            cuerpo del mensaje
	 * @param attachments
	 *            ficheros que se anexarán al mensaje
	 */
	public void send(String to, String subject, String text,
			File... attachments) {

		// chequeo de parámetros
		Assert.hasLength(to, "email 'to' needed");
		Assert.hasLength(subject, "email 'subject' needed");
		Assert.hasLength(text, "email 'text' needed");

		// asegurando la trazabilidad
		if (log.isDebugEnabled()) {
			final boolean usingPassword = !"".equals(mailSender.getPassword());
			log.debug("Sending email to: '" + to + "' [through host: '"
					+ mailSender.getHost() + ":" + mailSender.getPort()
					+ "', username: '" + mailSender.getUsername()
					+ "' usingPassword:" + usingPassword + "].");
			log.debug("isActive: " + active);
		}
		// el servicio esta activo?
		if (!active){
			return;
		}
		// plantilla para el envío de email
		final MimeMessage message = mailSender.createMimeMessage();

		try {
			// el flag a true indica que va a ser multipart
			final MimeMessageHelper helper = new MimeMessageHelper(message,
					true);

			// settings de los parámetros del envío
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(getFrom());
			helper.setText(text);

			// adjuntando los ficheros
			if (attachments != null) {
				for (int i = 0; i < attachments.length; i++) {
					FileSystemResource file = new FileSystemResource(
							attachments[i]);
					helper.addAttachment(attachments[i].getName(), file);
					if (log.isDebugEnabled()) {
						log.debug("File '" + file + "' attached.");
					}
				}
			}

		} catch (MessagingException e) {
			new RuntimeException(e);
		}

		// el envío
		this.mailSender.send(message);

	}

	public void send(String to, String subject, String template,
			Map<String, Object> mapTemplate, File... attachments) {

		// chequeo de parámetros
		Assert.hasLength(to, "email 'to' needed");
		Assert.hasLength(subject, "email 'subject' needed");

		// asegurando la trazabilidad
		if (log.isDebugEnabled()) {
			final boolean usingPassword = !"".equals(mailSender.getPassword());
			log.debug("Sending email to: '" + to + "' [through host: '"
					+ mailSender.getHost() + ":" + mailSender.getPort()
					+ "', username: '" + mailSender.getUsername()
					+ "' usingPassword:" + usingPassword + "].");
			log.debug("isActive: " + active);
		}
		// el servicio esta activo?
		if (!active){
			return;
		}
		// plantilla para el envío de email
		final MimeMessage message = mailSender.createMimeMessage();

		try {
			// el flag a true indica que va a ser multipart
			final MimeMessageHelper helper = new MimeMessageHelper(message,
					true);

			// settings de los parámetros del envío
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(getFrom());

			// cargamos el path general en donde se encuentra el dir del archivo
			// *.vm
	
			StrBuilder templateDir = new StrBuilder(VELOCITY_PATH);
			templateDir.append(template);
			templateDir.append(VELOCITY_EXTENSION);

			String body = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, templateDir.toString(), mapTemplate);
			
			message.setContent(body, "text/html");
		
			// adjuntando los ficheros
			if (attachments != null) {
				for (int i = 0; i < attachments.length; i++) {
					FileSystemResource file = new FileSystemResource(
							attachments[i]);
					helper.addAttachment(attachments[i].getName(), file);
					if (log.isDebugEnabled()) {
						log.debug("File '" + file + "' attached.");
					}
				}
			}

		} catch (MessagingException e) {
			new RuntimeException(e);
		}


		// el envío
		this.mailSender.send(message);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.mail.MailService#send(java.lang.String,
	 *      java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public void send(String to, String subject, String template,
			Map<String, Object> hTemplateVariables) {
		send(to, subject, template, hTemplateVariables, NO_ATTACHMENTS);

	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param basePath the basePath to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

}