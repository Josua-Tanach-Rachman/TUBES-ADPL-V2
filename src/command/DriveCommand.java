package command;
import model.Vehicle;

public class DriveCommand implements Command {
    private Vehicle vehicle;

    public DriveCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.drive();
    }
}