package crypto;

import com.sun.corba.se.spi.activation.NoSuchEndPoint;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import org.omg.CORBA.DynAnyPackage.Invalid;
/**
 *
 * @author jundix
 */
public class DESEncryptDecrypt {
        public static void doEncryptDecrypt() {
        try {
            String data = " Dasar Symmetric Cryptography";
            byte[] plain = data.getBytes("UTF8");

            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            keygen.init(56);
            Key key = keygen.generateKey();

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(plain);

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] originText = cipher.doFinal(cipherText);
            System.out.println("Plain Text : " + data);
            System.out.println("Enkripsi : " + new String(cipherText, "UTF8"));
            System.out.println("Enkripsi Heksa : " + MyStringUtils.getHexString(cipherText));
            System.out.println("Dekripsi :" + new String(originText, "UTF8"));
        } catch (UnsupportedEncodingException | InvalidKeyException
                | NoSuchAlgorithmException | BadPaddingException
                | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
    }

    public static void main(String[] args) {
        doEncryptDecrypt();
    }
}


