package factory;
import model.Truck;
import model.Vehicle;

public class TruckFactory {
    public static Vehicle getVehicle(){
        return new Truck();
    }
}
