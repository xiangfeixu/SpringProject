package util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DES加解密工具类
 * @author xuxiangfei
 * @date 2019/11/1
 */
public class DESUtil {

    private static String key = "icmoscsr";

    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * dec加密
     * @param encryptString 加密字符串
     * @return 加密过的字符串
     */
    public static String encrypt(String encryptString) {
        return encrypt(encryptString, key);
    }

    /**
     *  des加密
     * @param encryptString 待加密字符串
     * @param encryptKey    加密密钥
     * @return 加密过的字符串
     */
    public static String encrypt(String encryptString, String encryptKey){
        try {
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes("utf-8"), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes("utf-8"));
            return Base64.encodeBase64String(encryptedData);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * des解密
     * @param decryptString 待解密字符串
     * @return  解密过的字符串
     */
    public static String decrypt(String decryptString){
        return decrypt(decryptString, key);
    }

    /**
     * des解密
     * @param decryptString 待解密字符串
     * @param decryptKey    密钥
     * @return 解密过的字符串
     */
    public static String decrypt(String decryptString, String decryptKey){
        try {
            byte[] byteMi = Base64.decodeBase64(decryptString);
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes("utf-8"), "DES");
            Cipher cipher;
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte decryptedData[] = cipher.doFinal(byteMi);
            return new String(decryptedData,"utf-8");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "{\"userName\":\"GS02025\",\"serviceTypeId\":\"gsytck\",\"cityCode\":\"931\",\"catlId\":\"100000009602gsytck\",\"catlMark\":null,\"cityId\":\"931\",\"pageNum\":\"1\",\"pageSize\":\"100\"}";
        String encrypt = encrypt(str);
        System.out.println(encrypt);
        System.out.println(decrypt(encrypt));
    }
}
