package command;

import decorator.AirConditionerDecorator;
import model.Vehicle;

public class TurnOffACCommand implements Command {
    private Vehicle vehicle;

    public TurnOffACCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        AirConditionerDecorator vehicleMP3 = (AirConditionerDecorator) vehicle;
        vehicleMP3.offAC();
    }
}
