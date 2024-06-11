package command;

import decorator.MP3Decorator;
import model.Vehicle;

public class StopMusicCommand implements Command {
    private Vehicle vehicle;

    public StopMusicCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        MP3Decorator vehicleMP3 = (MP3Decorator) vehicle;
        vehicleMP3.stopMusic();
    }
}
