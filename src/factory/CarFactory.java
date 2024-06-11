package factory;
import model.Car;
import model.Vehicle;

public class CarFactory {
    public static Vehicle getVehicle(){
        return new Car();
    }
}