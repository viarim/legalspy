package com.accenture.bootcamp.legalspy.model;

import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Encrypts or compare provided strings using Bcrypt.
 */
public final class PasswordEncoder {
	private static final int salt = 12;	
	
	public static String encrypt(String originalPassword) throws NoSuchAlgorithmException {
        return BCrypt.hashpw(originalPassword, BCrypt.gensalt(salt));
	}

	public static boolean verifyHash(String originalPassword, String hashedPassword) {
        return BCrypt.checkpw(originalPassword, hashedPassword);
    }
}
