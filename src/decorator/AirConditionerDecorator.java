package decorator;
import model.Vehicle;

public class AirConditionerDecorator extends VehicleDecorator {

    Vehicle vehicle;

    public AirConditionerDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void onAC() {
        System.out.println("AC dinyalakan.");
    }

    public void offAC() {
        System.out.println("AC dimatikan.");
    }
}