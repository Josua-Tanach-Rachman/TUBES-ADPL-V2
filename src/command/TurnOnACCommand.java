package command;

import decorator.AirConditionerDecorator;
import model.Vehicle;

public class TurnOnACCommand implements Command {
    private Vehicle vehicle;

    public TurnOnACCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        AirConditionerDecorator vehicleMP3 = (AirConditionerDecorator) vehicle;
        vehicleMP3.onAC();
    }
}
