import java.util.Optional;

public interface TrafficRule {
    Optional<Violation> check(CarObservation observation);
}