package command;

import decorator.AirConditionerDecorator;
import decorator.MP3Decorator;
import model.Vehicle;

public class PlayMusicCommand implements Command {
    private Vehicle vehicle;

    public PlayMusicCommand(Vehicle vehicle) {
        this.vehicle = (Vehicle)vehicle;
    }

    @Override
    public void execute() {
        MP3Decorator vehicleMP3 = (MP3Decorator) vehicle;
        vehicleMP3.playMusic();
    }
}
