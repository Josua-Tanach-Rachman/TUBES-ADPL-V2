package model;
public class Truck implements Vehicle {
    private boolean engineStatus = false;
    private boolean frontLampStatus = false;

    public void startEngine() {
        if(engineStatus == false){
            System.out.println("Truck engine start");
            engineStatus = true;
        }
        else{
            System.out.println("Truck engine already on!");
        }
    }

    public void stopEngine() {
        if(engineStatus == true){
            System.out.println("Truck engine stop");  
            engineStatus = false;
        }
        else{
            System.out.println("Truck engine already off!");
        }
    }

    public void drive() {
        System.out.println("Truck is driving");
    }
    public void reverse() {
        System.out.println("Truck is reversing");
        
    }

    public void turnLeft() {
        System.out.println("Truck is turning left");
    }

    public void turnRight() {
        System.out.println("Truck is turning right");
    }

    @Override
    public void honk() {
        System.out.println("Truck is honking");
    }

    @Override
    public void turnOffFrontLamp() {
        if(frontLampStatus == true){
            System.out.println("Truck front lamp off");
            frontLampStatus = false;
        }
        else{
            System.out.println("Truck front lamp already off!");
        }
    }

    @Override
    public void turnOnFrontLamp() {
        if(frontLampStatus == false){
            System.out.println("Truck front lamp on");
            frontLampStatus = true;
        }
        else{
            System.out.println("Truck front lamp already on!");
        }
    }

    @Override
    public void display() {
        System.out.println("Truck is created");
    }
}