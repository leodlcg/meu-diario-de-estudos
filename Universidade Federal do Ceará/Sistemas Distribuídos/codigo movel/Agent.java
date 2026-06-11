import java.io.Serializable;

public interface Agent extends Serializable {
    String getName();
    void execute(HostContext context) throws Exception;
}