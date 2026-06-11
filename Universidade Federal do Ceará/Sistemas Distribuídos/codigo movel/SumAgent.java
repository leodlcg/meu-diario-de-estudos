import java.util.ArrayList;
import java.util.List;

public class SumAgent implements Agent {
    private final String name;
    private final List<HostStep> route;
    private int currentStep;
    private int total;
    private final String signature;

    public SumAgent(String name, List<HostStep> route, String signature) {
        this.name = name;
        this.route = new ArrayList<>(route);
        this.signature = signature;
        this.currentStep = 0;
        this.total = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(HostContext context) throws Exception {
        int localSum = context.getLocalNumbers()
                              .stream()
                              .mapToInt(Integer::intValue)
                              .sum();

        total += localSum;

        System.out.println("[" + context.getHostName() + "] Agente '" + name + "' executado.");
        System.out.println("[" + context.getHostName() + "] Soma local = " + localSum + ", acumulado = " + total);

        currentStep++;

        if (currentStep < route.size()) {
            HostStep next = route.get(currentStep);
            System.out.println("[" + context.getHostName() + "] Migrando agente para " + next.host() + ":" + next.port());
            MobileUtils.migrate(this, signature, next.host(), next.port());
        } else {
            System.out.println("[" + context.getHostName() + "] Execucao finalizada. Soma total = " + total);
        }
    }
}