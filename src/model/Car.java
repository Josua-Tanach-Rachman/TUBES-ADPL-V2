package model;
public class Car extends Vehicle {
    // private boolean engineStatus = false;
    // private boolean frontLampStatus = false;

    public void startEngine() {
        if(engineStatus == false){
            System.out.println("Car engine start");
            engineStatus = true;
        }
        else{
            System.out.println("Car engine already on!");
        }
    }

    public void stopEngine() {
        if(engineStatus == true){
            System.out.println("Car engine stop");  
            engineStatus = false;
        }
        else{
            System.out.println("Car engine already off!");
        }
    }

    public void drive() {
        if (engineStatus)
            System.out.println("Car is accelerating");
        else System.out.println("Car engine is off");
    
    }

    public void reverse() {
        if (engineStatus)
            System.out.println("Car is reversing");
        else System.out.println("Car engine is off");
    }

    public void turnLeft() {
        System.out.println("Car is turning left");

    }

    public void turnRight() {
        System.out.println("Car is turning right");
    }

    @Override
    public void honk() {
        System.out.println("Car is honking");
    }

    @Override
    public void turnOffFrontLamp() {
        if(frontLampStatus == true){
            System.out.println("Car front lamp off");
            frontLampStatus = false;
        }
        else{
            System.out.println("Car front lamp already off!");
        }
    }

    @Override
    public void turnOnFrontLamp() {
        if(frontLampStatus == false){
            System.out.println("Car front lamp on");
            frontLampStatus = true;
        }
        else{
            System.out.println("Car front lamp already on!");
        }
    }
}