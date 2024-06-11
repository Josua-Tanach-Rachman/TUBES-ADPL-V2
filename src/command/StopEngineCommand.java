package command;
import model.Vehicle;

public class StopEngineCommand implements Command {
    private Vehicle vehicle;

    public StopEngineCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.stopEngine();
    }
}