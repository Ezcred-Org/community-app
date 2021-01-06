/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.utils;


import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author anish
 */
public class AESUtil {


  public static String encrypt(String data, String encryptAlgo, String keyString)
      throws GeneralSecurityException {

//    SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");
    SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(keyString, Base64.NO_WRAP), "AES");

    byte[] ivParams = new byte[16];
//    SecureRandom secureRandom = new SecureRandom();
//    secureRandom.nextBytes(ivParams);

    byte[] dataBytes = data.getBytes();
    byte[] encoded = new byte[dataBytes.length + 16];
    System.arraycopy(ivParams, 0, encoded, 0, 16);
    System.arraycopy(dataBytes, 0, encoded, 16, dataBytes.length);

    Cipher cipher = Cipher.getInstance(encryptAlgo);
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(ivParams));
    return Base64.encodeToString(cipher.doFinal(encoded), Base64.NO_WRAP);

//    return new String(Base64.getEncoder().encode(cipher.doFinal(encoded)), StandardCharsets.UTF_8);
//    return new String(Base64.getEncoder().encode(cipher.doFinal(encoded)), StandardCharsets.UTF_8);
  }

  public static String decrypt(String encodedData, String encryptAlgo, String keyString)
      throws GeneralSecurityException {

//    SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");
    SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(keyString, Base64.NO_WRAP), "AES");
//    byte[] decodedData = Base64.getDecoder().decode(encodedData.getBytes(StandardCharsets.UTF_8));
    byte[] decodedData = Base64.decode(encodedData, Base64.NO_WRAP);

    byte[] ivParams = new byte[16];
    byte[] decodedEncrypted = new byte[decodedData.length - ivParams.length];
    System.arraycopy(decodedData, 0, ivParams, 0, ivParams.length);
    System.arraycopy(decodedData, ivParams.length, decodedEncrypted, 0,
        decodedData.length - ivParams.length);

    Cipher cipher = Cipher.getInstance(encryptAlgo);
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivParams));
    return new String(cipher.doFinal(decodedEncrypted));
  }
}
