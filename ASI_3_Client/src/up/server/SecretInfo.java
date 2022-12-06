package up.server;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SecretInfo {

    private String algorithm = "AES";
    private String transformation = "AES/ECB/PKCS5Padding";

    public byte[] encryptMessage(byte[] key, byte[] msgEnc){
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKey secretKey = new SecretKeySpec(key, algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(msgEnc);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decryptMessage(byte[] key, byte[] encMsg){
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(transformation);
            SecretKey secretKey = new SecretKeySpec(key, algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(encMsg));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
