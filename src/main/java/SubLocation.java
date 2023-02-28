import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.time.LocalDateTime;

public class SubLocation extends DrugLocation {
    @Subscribe
    public void receiveRequest(DrugDelivery request) {
        //Decrypt and log
        var decryptedMessage = RSA.decrypt(request.getEncryptedMessage(), keys.u());
        //Parse message
        var substr = decryptedMessage.substring(35);
        var receiverLocation = Enum.valueOf(Location.class, substr);
        if (receiverLocation != location) return;
        log(new ProtocolEntry(LocalDateTime.now(), location, request.getEncryptedMessage(), decryptedMessage));
        drugsStoredInKG += 100;
    }

    public SubLocation(EventBus eventBus, KeyPair keys, int index) {
        super(eventBus, keys, Location.fromInteger(index + 1));
    }

    public void requestDrugs() {
        communicationBus.post(new DrugRequest(location, keys.p()));
    }
}
