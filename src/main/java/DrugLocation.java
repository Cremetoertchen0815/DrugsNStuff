import com.google.common.eventbus.EventBus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class DrugLocation {
    protected final EventBus communicationBus;
    protected final KeyPair keys;
    protected final Location location;
    protected double drugsStoredInKG = 0;
    protected static ArrayList<ProtocolEntry> protocolEntries = new ArrayList<>();

    public DrugLocation(EventBus communicationBus, KeyPair keys, Location location) {
        this.communicationBus = communicationBus;
        this.keys = keys;
        this.location = location;
    }

    public static void log(ProtocolEntry entry) {
        protocolEntries.add(entry);
        entry.print();
    }

    public static ArrayList<ProtocolEntry> getProtocolEntries() {
        return protocolEntries;
    }
}
