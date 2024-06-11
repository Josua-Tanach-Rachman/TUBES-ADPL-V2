package command;

import model.Vehicle;

public class TurnOnFrontLamp implements Command {
    private Vehicle vehicle;

    public TurnOnFrontLamp(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.turnOnFrontLamp();
    }
}
