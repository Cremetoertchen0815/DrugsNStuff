import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Base {
    private final EventBus communicationBus;

    @Subscribe
    public void receiveRequest(DrugRequest request) {
        
    }

    public Base(EventBus communicationBus) {
        this.communicationBus = communicationBus;
    }
}
