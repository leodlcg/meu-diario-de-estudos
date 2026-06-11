import java.util.Set;

public class SimpleSecurity {
    private static final Set<String> TRUSTED_TOKENS = Set.of("TOKEN-UNIVERSIDADE-2026");

    public static boolean isTrusted(SignedAgent signedAgent) {
        return signedAgent != null
                && signedAgent.getSignature() != null
                && TRUSTED_TOKENS.contains(signedAgent.getSignature());
    }
}