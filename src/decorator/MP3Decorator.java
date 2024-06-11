package decorator;
import model.Vehicle;

public class MP3Decorator extends VehicleDecorator {

    Vehicle vehicle;

    public MP3Decorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void playMusic() {
        System.out.println("Musik dimainkan.");
    }

    public void stopMusic() {
        System.out.println("Musik dihentikan.");
    }
}