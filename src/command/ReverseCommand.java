package command;
import model.Vehicle;

public class ReverseCommand implements Command {
    private Vehicle vehicle;

    public ReverseCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.reverse();
    }
}