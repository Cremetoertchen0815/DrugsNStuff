public class DrugDelivery {
    private final byte[] message;
    private final String preEncryption;
    private final PublicRSAKey publicRSAKey;

    public DrugDelivery(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        String preEncryptionMessage = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        message = RSA.encrypt(preEncryptionMessage, publicRSAKey);
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
