package command;

import model.Vehicle;

public class TurnOffFrontLamp implements Command {
    private Vehicle vehicle;

    public TurnOffFrontLamp(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.turnOffFrontLamp();
    }
}
