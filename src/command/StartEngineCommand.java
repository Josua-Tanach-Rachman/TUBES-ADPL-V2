package command;
import model.Vehicle;

public class StartEngineCommand implements Command {
    private Vehicle vehicle;

    public StartEngineCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.startEngine();
    }
}