import java.math.BigInteger;

public class MSA {
    private RSACracker rsaCracker;
    private final KeyPair keyPair;
    private String encryptedMsg;
    private final SinaloaCartel sinaloaCartel;

    public MSA(SinaloaCartel cartel) {
        this.sinaloaCartel = cartel;
        this.keyPair = cartel.getBase().keys;
    }

    public void crackRequest(DrugRequest drugRequest) throws RSACrackerException {
        byte[] msg = drugRequest.getEncryptedMessage();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < msg.length; i++) {
            BigInteger bi = new BigInteger(String.valueOf(msg[i]));
            rsaCracker = new RSACracker(this.keyPair.p().e(), this.keyPair.p().n(), bi);
            BigInteger res = rsaCracker.execute();
            str.append(res.toString());
        }

        if (str.toString().equals(drugRequest.getPreEncryption())) {
            encryptedMsg = str.toString();
            takeDrugs();
        }
    }

    public void takeDrugs() {
        String location = this.encryptedMsg.substring(9, encryptedMsg.indexOf("XREQUEST"));
        int loc = Integer.parseInt(location);
        sinaloaCartel.getSubLocations()[loc].drugsStoredInKG -= 100;
    }

    public boolean crackDelivery(DrugDelivery drugDelivery) throws RSACrackerException {
        byte[] msg = drugDelivery.getEncryptedMessage();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < msg.length; i++) {
            BigInteger bi = new BigInteger(String.valueOf(msg[i]));
            rsaCracker = new RSACracker(this.keyPair.p().e(), this.keyPair.p().n(), bi);
            BigInteger res = rsaCracker.execute();
            str.append(res.toString());
        }

        return str.equals(drugDelivery.getPreEncryption());
    }
}
