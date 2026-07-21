import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
 
public class Main {
 
    public static void main(String[] args) {
 
        List<TrafficRule> rules = Arrays.asList(
                new SeatBeltRule(100),    
                new SpeedRule(CarObservation.CarType.PRIVATE, 80, 300),
                new SpeedRule(CarObservation.CarType.TRUCK, 70, 500),
                new SpeedRule(CarObservation.CarType.BUS, 60, 400)
                
        );
 
        QuantumRadar radar = new QuantumRadar(rules);
 
        radar.processObservation(
                new CarObservation("ABC1234", LocalDateTime.now(), CarObservation.CarType.PRIVATE, 94, false)).ifPresent(Fine::print);
        System.out.println();
        
        
        radar.processObservation(
                new CarObservation("XYZ777", LocalDateTime.now(), CarObservation.CarType.PRIVATE, 60, true)).ifPresent(Fine::print);
        System.out.println();

        
        radar.processObservation(
                new CarObservation("TRK001", LocalDateTime.now(), CarObservation.CarType.TRUCK, 75, true)).ifPresent(Fine::print);
        System.out.println();
       
 
        System.out.println("All fines: plate -> total EGP");
        radar.getAllPossibleFines()
                .forEach((plate, total) -> System.out.println(plate + " : " + total.intValue() + " EGP"));
 
    }           
}