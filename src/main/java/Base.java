import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.time.LocalDateTime;

public class Base extends DrugLocation {
    private DrugDelivery drugDelivery;
    @Subscribe
    public void receiveRequest(DrugRequest request) {
        //Decrypt and log
        var decryptedMessage = RSA.decrypt(request.getEncryptedMessage(), keys.u());
        log(new ProtocolEntry(LocalDateTime.now(), location, request.getEncryptedMessage(), decryptedMessage));
        //Parse message
        var start = decryptedMessage.indexOf("X") + 1;
        var length = decryptedMessage.lastIndexOf("X") - 19;
        var substr = decryptedMessage.substring(start, length);
        var receiverLocation = Enum.valueOf(Location.class, substr);
        drugsStoredInKG -= 100;

        this.drugDelivery = new DrugDelivery(receiverLocation, keys.p());
        communicationBus.post(drugDelivery);
    }

    public Base(EventBus communicationBus, KeyPair keys) {
        super(communicationBus, keys, Location.BASE);
        drugsStoredInKG = 15000;
    }

    public DrugDelivery getDrugDelivery() {
        return drugDelivery;
    }
}
