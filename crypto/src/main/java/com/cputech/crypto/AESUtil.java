package com.cputech.crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * Created by song on 2017/10/10.
 */
public class AESUtil {
    public static final String DEFAULT_CODING = "utf-8";

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        String content = "1234562222222222222222";
        String key = "0.77684973684155";
        System.out.println("加密前：" + content);
        SecretKeySpec skc = genSkc(key);
        byte[] encrypted = AES_CBC_Encrypt(content.getBytes(), skc);
        System.out.println("加密后：" + byteToHexString(encrypted));
        byte[] decrypted = AES_CBC_Decrypt(encrypted, skc, false);
        System.out.println("解密后：" + new String(decrypted));

    }

    public static SecretKeySpec genSkc(String key)throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(key.getBytes(DEFAULT_CODING));
        SecretKeySpec skc = new SecretKeySpec(thedigest, "AES");
        return skc;
    }

    public static byte[] AES_CBC_Encrypt(byte[] content, SecretKeySpec skc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skc);
        return /*Base64.encodeBase64*/(cipher.doFinal(content));
    }

    public static byte[] AES_CBC_Decrypt(byte[] content, SecretKeySpec skc, boolean needsDecode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skc);
        System.out.println((content).length);
        if(needsDecode)
            return cipher.doFinal(Base64.decodeBase64(content));
        return cipher.doFinal((content));
    }

    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


}
