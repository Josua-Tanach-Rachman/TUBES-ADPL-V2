package command;

import decorator.AirConditionerDecorator;
import decorator.MP3Decorator;
import decorator.VehicleDecorator;
import model.Vehicle;

public class TurnOffACCommand implements Command {
    private Vehicle vehicle;

    public TurnOffACCommand(Vehicle vehicle) {
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
            vehicleMP3.offAC();
        }
    }
}
