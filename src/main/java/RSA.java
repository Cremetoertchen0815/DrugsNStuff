import java.math.BigInteger;
import java.nio.charset.Charset;

public class RSA {
    public static byte[] encrypt(String plainMessage, PublicRSAKey key) {
        byte[] bytes = plainMessage.getBytes(Charset.defaultCharset());
        return internalEncrypt(new BigInteger(bytes), key).toByteArray();
    }

    public static String decrypt(byte[] cipher, PrivateRSAKey key) {
        byte[] msg = internalDecrypt(new BigInteger(cipher), key).toByteArray();
        return new String(msg);
    }

    private static BigInteger internalEncrypt(BigInteger message, PublicRSAKey key) {
        return message.modPow(key.e(), key.n());
    }

    private static BigInteger internalDecrypt(BigInteger message, PrivateRSAKey key) {
        return message.modPow(key.d(), key.n());
    }
}
