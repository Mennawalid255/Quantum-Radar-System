import java.util.Optional;
 

public class SpeedRule implements TrafficRule {
 
    private final CarObservation.CarType applicableCarType;
    private final double maxSpeed;
    private final double fee;
 
    public SpeedRule( CarObservation.CarType applicableCarType, double maxSpeed, double fee) {
        this.applicableCarType = applicableCarType;
        this.maxSpeed = maxSpeed;
        this.fee = fee;
    }
 

    @Override
    public Optional<Violation> check(CarObservation observation) {
        if (observation.getCarType() == applicableCarType && observation.getSpeed() > maxSpeed) {
            String description = "speed of " + (int) observation.getSpeed()
                    + " exceeded max allowed " + (int) maxSpeed;
            return Optional.of(new Violation(description, fee));
        }

        return Optional.empty();
    }
}