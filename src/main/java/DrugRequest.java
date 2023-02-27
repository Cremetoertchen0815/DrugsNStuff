public class DrugRequest {
    private final String message;
    public DrugRequest(Location location, PublicRSAKey publicRSAKey) {
        var preEncryptionMessage = "LOCATIONX" + location.name() + "XREQUESTXONEHUNDREDX";
        message = RSA.encrypt(preEncryptionMessage, publicRSAKey);
    }

    public String getEncryptedMessage() {
        return message;
    }
}
