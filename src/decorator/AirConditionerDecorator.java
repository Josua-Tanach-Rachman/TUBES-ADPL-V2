package decorator;
import model.Vehicle;

public class AirConditionerDecorator extends VehicleDecorator {
    boolean statusAC = false;

    public AirConditionerDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void onAC() {
        if(statusAC == false){
            System.out.println("AC dinyalakan.");
            statusAC = true;
        }
        else{
            System.out.println("AC sudah menyala.");
        }
    }

    public void offAC() {
        if(statusAC == true){
            System.out.println("AC dimatikan.");
            statusAC = false;
        }
        else{
            System.out.println("AC berada dalam kondisi mati.");
        }
        
    }

    @Override
    public void display() {
        this.vehicle.display();
        System.out.println("Dimodifikasi dengan AC");
    }
}