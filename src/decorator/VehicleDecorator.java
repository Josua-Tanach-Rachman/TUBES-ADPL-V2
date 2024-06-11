package decorator;
// Decorator Pattern

import model.Vehicle;

public abstract class VehicleDecorator extends Vehicle {
    protected Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startEngine() {
        vehicle.startEngine();
    }

    public void stopEngine() {
        vehicle.stopEngine();
    }

    @Override
    public void drive() {
        vehicle.drive();
    }

    @Override
    public void reverse() {
        vehicle.reverse();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    @Override
    public void honk() {
        vehicle.honk();
    }

    @Override
    public void turnOffFrontLamp() {
        vehicle.turnOffFrontLamp();
    }

    @Override
    public void turnOnFrontLamp() {
        vehicle.turnOnFrontLamp();
    }
}