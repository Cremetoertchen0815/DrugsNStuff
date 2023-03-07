import java.math.BigInteger;
import java.nio.charset.Charset;

public class RSA {
    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger n;
    private final BigInteger t;
    private final BigInteger e;
    private final BigInteger d;
    private final PublicRSAKey publicKey;
    private final PrivateRSAKey privateKey;

    public RSA() {
        p = new BigInteger("211363876292463127824964365018172523449");
        q = new BigInteger("188002462532244176330161643856367865419");

        n = p.multiply(q);
        t = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = getCoPrime(t);
        d = e.modInverse(t);

        publicKey = new PublicRSAKey(n, e);
        privateKey = new PrivateRSAKey(n, d);
    }

    public KeyPair getKeyPair(){
        return new KeyPair(publicKey,privateKey);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getT() {
        return t;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public PublicRSAKey getPublicKey() {
        return publicKey;
    }

    public PrivateRSAKey getPrivateKey() {
        return privateKey;
    }

    public byte[] encrypt(String plainMessage, PublicRSAKey key) {
        byte[] bytes = plainMessage.getBytes(Charset.defaultCharset());
        return internalEncrypt(new BigInteger(bytes), key).toByteArray();
    }

    public String decrypt(byte[] cipher, PrivateRSAKey key) {
        byte[] msg = internalDecrypt(new BigInteger(cipher), key).toByteArray();
        return new String(msg);
    }

    private BigInteger internalEncrypt(BigInteger message, PublicRSAKey key) {
        return message.modPow(key.e(), key.n());
    }

    private BigInteger internalDecrypt(BigInteger message, PrivateRSAKey key) {
        return message.modPow(key.d(), key.n());
    }

    public boolean isCoPrime(BigInteger c, BigInteger n) {
        BigInteger one = new BigInteger("1");
        return c.gcd(n).equals(one);
    }

    private BigInteger getCoPrime(BigInteger n) {
        BigInteger result = new BigInteger(n.toString());
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        result = result.subtract(two);

        while (result.intValue() > 1) {
            if (result.gcd(n).equals(one)) {
                break;
            }
            result = result.subtract(one);
        }

        return result;
    }
}
