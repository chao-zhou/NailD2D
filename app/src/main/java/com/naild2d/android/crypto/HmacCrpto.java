package com.naild2d.android.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by ebread on 2015/3/15.
 */
public class HmacCrpto {

    public static final String HMAC_SHA1 = "HmacSHA1";

    public static byte[] digestToBytes(String msg, String keyString, String algo){
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);
            return mac.doFinal(msg.getBytes("UTF-8"));

        } catch (UnsupportedEncodingException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }

        return  null;
    }

    public static String digestToHex(String msg, String keyString, String algo) {
        byte[] bytes = digestToBytes(msg,keyString,algo);
        if(bytes == null)
            return  null;

        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        return hash.toString();
    }

    public static byte[] digestSHA1ToBytes(String msg, String keyString){
        return digestToBytes(msg, keyString, HMAC_SHA1);
    }

}
