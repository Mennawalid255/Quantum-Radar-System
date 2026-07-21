
import java.time.LocalDateTime;

public class CarObservation {
    private final String plateNumber;
    private final LocalDateTime date;
    public enum CarType {
        PRIVATE, TRUCK, BUS
    }
    private final CarType carType;
    private final int speed;
    private final boolean seatbeltFastened;

    public CarObservation(String plateNumber, LocalDateTime date, CarType carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isSeatbeltFastened() {
        return seatbeltFastened;
    }

    @Override
    public String toString() {
        return "CarObservation{" +
                "plateNumber='" + plateNumber + '\'' +
                ", date=" + date +
                ", carType=" + carType +
                ", speed=" + speed +
                ", seatbeltFastened=" + seatbeltFastened +
                '}';
    }
    
}
