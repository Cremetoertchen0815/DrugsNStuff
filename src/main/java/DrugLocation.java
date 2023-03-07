import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public abstract class DrugLocation {
    protected static ArrayList<ProtocolEntry> protocolEntries = new ArrayList<>();
    protected final EventBus communicationBus;
    protected final KeyPair keys;
    protected final Location location;
    protected double drugsStoredInKG = 0;

    public DrugLocation(EventBus communicationBus, KeyPair keys, Location location) {
        this.communicationBus = communicationBus;
        this.keys = keys;
        this.location = location;
        communicationBus.register(this);
    }

    public static void log(ProtocolEntry entry) {
        protocolEntries.add(entry);
        entry.print();
    }

    public static ArrayList<ProtocolEntry> getProtocolEntries() {
        return protocolEntries;
    }
}
