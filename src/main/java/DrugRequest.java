public class DrugRequest {
    private final String message;
    private String preEncryption;
    private PublicRSAKey publicRSAKey;

    public DrugRequest(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
        var preEncryptionMessage = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
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
