import com.google.common.eventbus.EventBus;

public class SinaloaCartel {
    private final KeyPair keys;
    private final Base base;
    private final SubLocation[] subLocations;
    private final EventBus eventBus;

    public SinaloaCartel() {
        keys = new KeyPair("211363876292463127824964365018172523449", "188002462532244176330161643856367865419");
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
