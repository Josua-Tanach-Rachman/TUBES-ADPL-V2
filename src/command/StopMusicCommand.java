package command;

import decorator.AirConditionerDecorator;
import decorator.MP3Decorator;
import decorator.VehicleDecorator;
import model.Vehicle;

public class StopMusicCommand implements Command {
    private Vehicle vehicle;

    public StopMusicCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        if(vehicle instanceof AirConditionerDecorator){
            VehicleDecorator decorator = (VehicleDecorator) vehicle;
            decorator = (VehicleDecorator) decorator.getInnerVehicle();
            vehicle = (MP3Decorator) decorator;
        }
        if(vehicle instanceof MP3Decorator){
            MP3Decorator vehicleMP3 = (MP3Decorator) vehicle;
            vehicleMP3.stopMusic();
        }
    }
}
