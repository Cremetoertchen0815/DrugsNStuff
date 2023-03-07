public class DrugDelivery {
    private final byte[] message;
    private String preEncryption;
    private PublicRSAKey publicRSAKey;

    private RSA rsa;

    public DrugDelivery(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        String preEncryptionMessage = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        rsa = new RSA();
        message = rsa.encrypt(preEncryptionMessage, publicRSAKey);
    }

    public byte[] getEncryptedMessage() {
        return message;
    }

    public PublicRSAKey getPublicRSAKey() {
        return publicRSAKey;
    }

    public String getPreEncryption() {
        return preEncryption;
    }
}
