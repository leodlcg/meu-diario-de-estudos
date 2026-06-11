import java.io.Serializable;

public record HostStep(String host, int port) implements Serializable {}