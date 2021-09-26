package com.sintoburi.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Component;

@Component
public class UtilRsaKey {

	/**
	 * 256비트 RSA 키쌍 생성
	 */
	public KeyPair generateRsaKeyPair() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator gen;
		gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(256, secureRandom);
		KeyPair keyPair = gen.genKeyPair();
		return keyPair;
	}

	/**
	 * Public Key로 RSA 암호화를 수행
	 * 
	 * @param plainText 암호화 평문
	 * @param publicKey 공개키
	 * @return
	 */
	public String encryptRSA(String plainText, PublicKey publicKey) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytePlain = cipher.doFinal(plainText.getBytes());
		String encrypted = Base64.getEncoder().encodeToString(bytePlain);
		return encrypted;
	}

	/**
	 * Private Key로 RSA 복호화를 수행
	 * 
	 * @param encrypted  암호화된 이진데이터를 base64로 인코딩한 문자열
	 * @param privateKey 복호화를 위한 개인키
	 * @return
	 */
	public String decryptRSA(String encrypted, PrivateKey privateKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA");
		byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bytePlain = cipher.doFinal(byteEncrypted);
		String decrypted = new String(bytePlain, "utf-8");
		return decrypted;
	}

	/**
	 * Base64 인코딩된 private key 문자열로 부터 PrivateKey 객체 획득
	 * 
	 * @param keyString
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static PrivateKey getPrivateKeyFromBase64String(final String keyString)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		final String privateKeyString = keyString.replaceAll("\\n", "").replaceAll("-{5}[ a-zA-Z]*-{5}", "");
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
		return keyFactory.generatePrivate(keySpecPKCS8);
	}

	/**
	 *Base64 인코딩된 public key 문자열로 부터 PublicKey 객체 획 
	 * 
	 * @param keyString
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static PublicKey getPublicKeyFromBase64String(final String keyString)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		final String publicKeyString = keyString.replaceAll("\\n", "").replaceAll("-{5}[ a-zA-Z]*-{5}", "");
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString));
		return keyFactory.generatePublic(keySpecX509);
	}
}
