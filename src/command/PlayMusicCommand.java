package command;
import decorator.MP3Decorator;
import decorator.VehicleDecorator;
import model.Vehicle;

public class PlayMusicCommand implements Command {
    private Vehicle vehicle;

    public PlayMusicCommand(Vehicle vehicle) {
        this.vehicle = (Vehicle)vehicle;
    }

    @Override
    public void execute() {
        if(vehicle instanceof VehicleDecorator){
            VehicleDecorator decorator = (VehicleDecorator) vehicle;
            decorator = (VehicleDecorator) decorator.getInnerVehicle();
            vehicle = (MP3Decorator) decorator;
        }
        if(vehicle instanceof MP3Decorator){
            MP3Decorator vehicleMP3 = (MP3Decorator) vehicle;
            vehicleMP3.playMusic();
        }
    }
}
