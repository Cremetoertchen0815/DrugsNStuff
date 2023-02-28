public class DrugDelivery {
    private final String message;
    public DrugDelivery(Location location, PublicRSAKey publicRSAKey) {
        var preEncryptionMessage = "DRUGSXONEHUNDREDXSENDXTOYLOCATIONX" + location.name();
        message = RSA.encrypt(preEncryptionMessage, publicRSAKey);
    }

    public String getEncryptedMessage() {
        return message;
    }
}
