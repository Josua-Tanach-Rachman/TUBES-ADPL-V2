package command;
import model.Vehicle;

public class TurnLeftCommand implements Command {
    private Vehicle vehicle;

    public TurnLeftCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.turnLeft();
    }
}