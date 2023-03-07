import java.time.LocalDateTime;

public record ProtocolEntry(LocalDateTime dateTime, Location location, byte[] encrypted, String decrypted) {
    public void print() {
        System.out.println("[" + dateTime.toString() + " | " + location.name() + "]" + "Message logged: " + encrypted + "(" + decrypted + ")");
    }
}
