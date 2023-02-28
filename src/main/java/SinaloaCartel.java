import com.google.common.eventbus.EventBus;

public class SinaloaCartel {
    private Base base;
    private SubLocation[] subLocations;
    private EventBus eventBus;
    private final KeyPair keys;
    public SinaloaCartel() {
        keys = RSA.generateRandomKeyPair();
        eventBus = new EventBus();
        base = new Base(eventBus, keys);
        subLocations = new SubLocation[20];
        for (int i = 0; i < subLocations.length; i++) subLocations[i] = new SubLocation(eventBus, keys, i);
    }

    public Base getBase() {
        return base;
    }

    public SubLocation[] getSubLocations() {
        return subLocations;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
