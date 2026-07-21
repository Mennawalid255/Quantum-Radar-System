import java.util.List;

public class Fine {
    private final String plateNumber;
    private final List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Violation violation : violations) {
            total += violation.getFee();
        }
        return total;
    }

    public void print() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + (int) getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation violation : violations) {
            System.out.println("- " + violation.getDescription() + " : " + (int) violation.getFee() + " EGP");
        }
    }
}