public class DrugRequest {
    private final byte[] message;
    private String preEncryption;
    private PublicRSAKey publicRSAKey;

    public DrugRequest(Location location, PublicRSAKey publicRSAKey) {
        this.publicRSAKey = publicRSAKey;
        this.preEncryption = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
        var preEncryptionMessage = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
        var rsa = new RSA();
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
