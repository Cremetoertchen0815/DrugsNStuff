import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;


public class Base extends DrugLocation {

    private RSA rsa;
    @Subscribe
    public void receiveRequest(DrugRequest request) {
        //Decrypt and log
        rsa = new RSA();
        var decryptedMessage = rsa.decrypt(request.getEncryptedMessage(),rsa.getPrivateKey());
        log(new ProtocolEntry(LocalDateTime.now(), location, request.getEncryptedMessage(), decryptedMessage));
        //Parse message
        var start = decryptedMessage.indexOf("X") + 1;
        var length = decryptedMessage.lastIndexOf("X") - 19;
        var substr = decryptedMessage.substring(start, length);
        var receiverLocation = Enum.valueOf(Location.class, substr);
        drugsStoredInKG -= 100;

        communicationBus.post(new DrugDelivery(receiverLocation, keys.p()));
    }

    public Base(EventBus communicationBus, KeyPair keys) {
        super(communicationBus, keys, Location.BASE);
        drugsStoredInKG = 15000;
    }
}
