package decorator;
// Decorator Pattern

import model.Vehicle;

public abstract class VehicleDecorator implements Vehicle{
    protected Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void drive() {
        vehicle.drive();
    }

    @Override
    public void honk() {
        vehicle.honk();
    }

    @Override
    public void reverse() {
        vehicle.reverse();
    }

    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }

    @Override
    public void turnOffFrontLamp() {
        vehicle.turnOffFrontLamp();
    }

    @Override
    public void turnOnFrontLamp() {
        vehicle.turnOnFrontLamp();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    public Vehicle getInnerVehicle() {
        return this.vehicle;
    }
}