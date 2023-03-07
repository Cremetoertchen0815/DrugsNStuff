import java.math.BigInteger;

public class KeyPair {

    private final PublicRSAKey p;
    private final PrivateRSAKey u;
    public KeyPair(String argP, String argQ) {
        var pp = new BigInteger(argP);
        var q = new BigInteger(argQ);

        var n = pp.multiply(q);
        var t = (pp.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        var e = getCoPrime(t);
        var d = e.modInverse(t);

        this.p = new PublicRSAKey(n, e);
        u = new PrivateRSAKey(n, d);
    }

    public PublicRSAKey p() {
        return p;
    }

    public PrivateRSAKey u() {
        return u;
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
