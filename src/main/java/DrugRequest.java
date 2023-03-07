public class DrugRequest {
    private final byte[] message;
    private final String preEncryption;
    private final PublicRSAKey publicRSAKey;

    public DrugRequest(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
        var preEncryptionMessage = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
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
