package command;

import model.Vehicle;

public class HonkCommand implements Command {
    private Vehicle vehicle;

    public HonkCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.honk();
    }
}
