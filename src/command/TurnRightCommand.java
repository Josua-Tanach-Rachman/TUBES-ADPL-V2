package command;
import model.Vehicle;

class TurnRightCommand implements Command {
    private Vehicle vehicle;

    public TurnRightCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.turnRight();
    }
}