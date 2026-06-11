import java.io.Serializable;

public class SignedAgent implements Serializable {
    private final Agent agent;
    private final String signature;

    public SignedAgent(Agent agent, String signature) {
        this.agent = agent;
        this.signature = signature;
    }

    public Agent getAgent() {
        return agent;
    }

    public String getSignature() {
        return signature;
    }
}