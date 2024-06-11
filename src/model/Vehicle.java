package model;

public interface Vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void drive();
    public abstract void reverse();
    public abstract void turnLeft();
    public abstract void turnRight();
    public abstract void honk();
    public abstract void turnOnFrontLamp();
    public abstract void turnOffFrontLamp();
    public abstract void display();
}