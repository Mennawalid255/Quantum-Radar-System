import java.util.Optional;

public class SeatBeltRule implements TrafficRule {
    private final double fee;

    public SeatBeltRule(double fee) {
        this.fee = fee;
    }

    @Override
    public Optional<Violation> check(CarObservation observation) {
            if (observation.isSeatbeltFastened()) {
                return Optional.empty();
            }
            else {
                return Optional.of(new Violation("Seatbelt not fastened", fee));
            }
    }
}