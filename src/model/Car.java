package model;
public class Car implements Vehicle {
    private boolean engineStatus = false;
    private boolean frontLampStatus = false;

    public void startEngine() {
        if(engineStatus == false){
            System.out.println("Mesin mobil menyala");
            engineStatus = true;
        }
        else{
            System.out.println("Mesin mobil sudah menyala!");
        }
    }

    public void stopEngine() {
        if(engineStatus == true){
            System.out.println("Mesin mobil mati");  
            engineStatus = false;
        }
        else{
            System.out.println("Mesin mobil sudah mati!");
        }
    }

    public void drive() {
        if (engineStatus)
            System.out.println("Mobil sedang melaju");
        else System.out.println("Mesin mobil masih mati");
    
    }

    public void reverse() {
        if (engineStatus)
            System.out.println("Mobil berjalan mundur");
        else System.out.println("Mesin mobil masih mati");
    }

    public void turnLeft() {
        System.out.println("Mobil belok kiri");

    }

    public void turnRight() {
        System.out.println("Mobil belok kanan");
    }

    @Override
    public void honk() {
        System.out.println("Mobil membunyikan klakson");
    }

    @Override
    public void turnOffFrontLamp() {
        if(frontLampStatus == true){
            System.out.println("Lampu depan mobil mati");
            frontLampStatus = false;
        }
        else{
            System.out.println("Lampu depan mobil sudah mati!");
        }
    }

    @Override
    public void turnOnFrontLamp() {
        if(frontLampStatus == false){
            System.out.println("Lampu depan mobil menyala");
            frontLampStatus = true;
        }
        else{
            System.out.println("Lampu depan mobil sudah menyala!");
        }
    }

    @Override
    public void display() {
        System.out.println("Mobil berhasil dibuat");
    }
}