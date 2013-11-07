/**
 * 
 */
package co.icesi.troca.services.seguridad.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import co.icesi.troca.services.seguridad.EncoderManager;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class EncoderManagerImpl
 * @date 5/11/2013
 *
 */
@Service("encoderManager")
public class EncoderManagerImpl implements EncoderManager {

	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * MD52
	 */
	private static final String MD52 = "MD5";

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.seguridad.EncoderManager#encodeMd5Hash(java.lang.String)
	 */
	@Override
	public String encodeMd5Hash(String input) {
	String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance(MD52);
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
	}


