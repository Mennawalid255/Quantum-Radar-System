import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QuantumRadar {
    private final List<TrafficRule> rules;
    private final List<Fine> issuedFines = new ArrayList<>();

    public QuantumRadar(List<TrafficRule> rules) {
        this.rules = rules;
    }

    public Optional<Fine> processObservation(CarObservation obs) {
        List<Violation> violations = new ArrayList<>();

        for (TrafficRule rule : rules) {
            Optional<Violation> result = rule.check(obs);
            if (result.isPresent()) {
                Violation violation = result.get();
                violations.add(violation);
            }
        }

        if (violations.isEmpty()) {
            return Optional.empty();
        }

        Fine fine = new Fine(obs.getPlateNumber(), violations);
        issuedFines.add(fine);
        return Optional.of(fine);
    }

    public Map<String, Double> getAllPossibleFines() {
        Map<String, Double> totals = new LinkedHashMap<>();

        for (Fine fine : issuedFines) {
            String plate = fine.getPlateNumber();
            double amount = fine.getTotalAmount();

            if (totals.containsKey(plate)) {
                double currentTotal = totals.get(plate);
                totals.put(plate, currentTotal + amount);
            } else {
                totals.put(plate, amount);
            }
        }

        return totals;
    }

}