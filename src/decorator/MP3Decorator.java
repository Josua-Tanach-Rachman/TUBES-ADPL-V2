package decorator;
import model.Vehicle;

public class MP3Decorator extends VehicleDecorator {
    boolean statusMusic = false;

    public MP3Decorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void playMusic() {
        if(statusMusic == false){
            System.out.println("Musik dimainkan.");
            statusMusic = true;
        }
        else{
            System.out.println("Musik sudah menyala.");
        }
    }

    public void stopMusic() {
        if(statusMusic == true){
            System.out.println("Musik dimatikan.");
            statusMusic = false;
        }
        else{
            System.out.println("Musik berada dalam kondisi mati.");
        }
    }

    @Override
    public void display() {
        this.vehicle.display();
        System.out.println("Dimodifikasi dengan MP3");
    }
}