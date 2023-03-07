import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

public class MSA{
    private RSACracker rsaCracker;
    private KeyPair keyPair;
    private String encryptedMsg;
    private SinaloaCartel sinaloaCartel;

    public MSA(SinaloaCartel cartel) {
        this.sinaloaCartel = cartel;
        this.keyPair = cartel.getBase().keys;
    }

    public void crackRequest(DrugRequest drugRequest) throws RSACrackerException {
        String msg = drugRequest.getEncryptedMessage();
        byte[] msgBytes = msg.getBytes();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < msgBytes.length; i++) {
            BigInteger bi = new BigInteger(String.valueOf(msgBytes[i]));
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
        String msg = drugDelivery.getEncryptedMessage();
        byte[] msgBytes = msg.getBytes();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < msgBytes.length; i++) {
            BigInteger bi = new BigInteger(String.valueOf(msgBytes[i]));
            rsaCracker = new RSACracker(this.keyPair.p().e(), this.keyPair.p().n(), bi);
            BigInteger res = rsaCracker.execute();
            str.append(res.toString());
        }

        return str.equals(drugDelivery.getPreEncryption());
    }
}
