import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HostContext implements Serializable {
    private final String hostName;
    private final List<Integer> localNumbers;

    public HostContext(String hostName, List<Integer> localNumbers) {
        this.hostName = hostName;
        this.localNumbers = new ArrayList<>(localNumbers);
    }

    public String getHostName() {
        return hostName;
    }

    public List<Integer> getLocalNumbers() {
        return new ArrayList<>(localNumbers);
    }
}