/**
 * 
 */
package co.icesi.troca.test.mail;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import co.icesi.troca.mail.MailService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class MailServiceImplTest
 * @date 3/11/2013
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class MailServiceImplTest  {

	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * LOGO_PNG
	 */
	private static final String LOGO_PNG = "/logo.png";
	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * USER_DIR
	 */
	private static final String USER_DIR = "user.dir";
	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * FILE_LOGO
	 */
	private static final File FILE_LOGO = new File(new StringBuilder(System.getProperty(USER_DIR).toString()).append(LOGO_PNG).toString());
	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * CONTENT_MAIL_TEST
	 */
	private static final String CONTENT_MAIL_TEST = "Prueba del envío de correo electrónico.";
	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * TITLE_MAIL_TEST
	 */
	private static final String TITLE_MAIL_TEST = "Test de envío de email.";
	/**
	 * 3/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * GMAIL_DIR
	 */
	private static final String GMAIL_DIR = "elmerdiazlazo@gmail.com";
	@Autowired
	private MailService service;

	/**
	 * Test method for
	 * {@link co.icesi.troca.mail.impl.MailServiceImpl#send(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSend() {
		try {
			assertNotNull(GMAIL_DIR);
			service.send(GMAIL_DIR, TITLE_MAIL_TEST,
					CONTENT_MAIL_TEST);
			
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.mail.impl.MailServiceImpl#send(java.lang.String, java.lang.String, java.lang.String, java.io.File[])}
	 * .
	 */
	@Test
	public void testSendFileArray() {
	
		try {
			service.send(GMAIL_DIR, TITLE_MAIL_TEST,
					CONTENT_MAIL_TEST,FILE_LOGO);
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	

}
