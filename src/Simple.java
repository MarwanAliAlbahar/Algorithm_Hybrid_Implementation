import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;

public class Simple {
    public static byte[] encriptedKey;
    public static PrivateKey privKey;

    public static void main( String[] args ) throws Exception {
        // the data to encrypt
        String data = "111";
        // add bouncy castle as provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // encrypt the data
        System.out.println("Encrypting : " + data + " length : " + data.getBytes().length);
        byte[] encryptedData = encrypt(data.getBytes());
     //   System.out.println("bytes"+(data.getBytes()));
        byte[] decryptedDate = decrypt(encryptedData);
      //  System.out.println("encryptedData"+(encryptedData));
        System.out.println("Decrypted : " + new String(decryptedDate) + " length : " + decryptedDate.length);
        // Check if the data is equals the decrypted data
        System.out.println( "Data comparison :" + data.equals( new String( decryptedDate ) ) );
    }

    public static byte[] decrypt( byte[] byteText ) throws Exception {
        // decrypt the key using rsa
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.UNWRAP_MODE, privKey);
        Key decryptedKey = rsaCipher.unwrap(encriptedKey, "AES", Cipher.SECRET_KEY);
      //  System.out.println("Key1"+(Cipher.SECRET_KEY));

        // decrypt the data using the decryptedKey
        Cipher twofishCipher = Cipher.getInstance("twofish");
        twofishCipher.init(Cipher.DECRYPT_MODE, decryptedKey);
        byte[] decryptedTwoFish = twofishCipher.doFinal(byteText);
      //   System.out.println("Key2"+(twofishCipher.doFinal(byteText)));
        // and finaly decrypt the twofish decrypted data using aes
        Cipher AesCipher = Cipher.getInstance("AES");
        AesCipher.init(Cipher.DECRYPT_MODE, decryptedKey);
        byte[] byteCipherText = AesCipher.doFinal(decryptedTwoFish);
      //   System.out.println("Key3"+(AesCipher.doFinal(decryptedTwoFish)));
        return byteCipherText;
    }

    public static byte[] encrypt( byte[] byteText ) throws Exception {
        // Generate a random aes key
        KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
        KeyGen.init(128);
        SecretKey mainKey = KeyGen.generateKey();
        System.out.println("Key generated"+KeyGen.generateKey());
        // encrypt the data using aes algorithm
        Cipher AesCipher = Cipher.getInstance("AES");
        AesCipher.init(Cipher.ENCRYPT_MODE, mainKey);
        byte[] byteCipherText = AesCipher.doFinal(byteText);
         System.out.println("KeyAES"+(AesCipher.doFinal(byteText)));
        // encrypt the data using twofish algorithm
        Cipher twofishCipher = Cipher.getInstance("twofish");
        twofishCipher.init(Cipher.ENCRYPT_MODE, mainKey);
        byte[] encrypted = twofishCipher.doFinal(byteCipherText);
        System.out.println("TWOFISH"+(twofishCipher.doFinal(byteCipherText)));
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair kpa = kpg.genKeyPair();
        PublicKey pubKey = kpa.getPublic();
        privKey = kpa.getPrivate();
     //    System.out.println("private key"+kpa.getPrivate());
      //   System.out.println ("public key"+kpa.getPublic());
      //    System.out.println("Pair"+kpg.genKeyPair());

        // ecrypt the key using rsa
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.WRAP_MODE, pubKey);
        encriptedKey = rsaCipher.wrap(mainKey);

        return encrypted;
    }
}
