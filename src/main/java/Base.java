import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.time.LocalDateTime;

public class Base extends DrugLocation {

    @Subscribe
    public void receiveRequest(DrugRequest request) {
        //Decrypt and log
        var decryptedMessage = RSA.decrypt(request.getEncryptedMessage(), keys.u());
        log(new ProtocolEntry(LocalDateTime.now(), location, request.getEncryptedMessage(), decryptedMessage));
        //Parse message
        var start = decryptedMessage.indexOf("X");
        var length = decryptedMessage.lastIndexOf("X") - start - 18;
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
