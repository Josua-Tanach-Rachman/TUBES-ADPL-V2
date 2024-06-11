package command;

import decorator.AirConditionerDecorator;
import decorator.MP3Decorator;
import decorator.VehicleDecorator;
import model.Vehicle;

public class TurnOnACCommand implements Command {
    private Vehicle vehicle;

    public TurnOnACCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        if(vehicle instanceof MP3Decorator){
            VehicleDecorator decorator = (VehicleDecorator) vehicle;
            decorator = (VehicleDecorator) decorator.getInnerVehicle();
            vehicle = (AirConditionerDecorator) decorator;
        }
        if(vehicle instanceof AirConditionerDecorator){
            AirConditionerDecorator vehicleMP3 = (AirConditionerDecorator) vehicle;
            vehicleMP3.onAC();
        }
    }
}
