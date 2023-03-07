public class DrugDelivery {
    private final String message;
    private String preEncryption;
    private PublicRSAKey publicRSAKey;

    public DrugDelivery(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        var preEncryptionMessage = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        message = RSA.encrypt(preEncryptionMessage, publicRSAKey);
    }

    public String getEncryptedMessage() {
        return message;
    }

    public PublicRSAKey getPublicRSAKey() {
        return publicRSAKey;
    }

    public String getPreEncryption() {
        return preEncryption;
    }
}
