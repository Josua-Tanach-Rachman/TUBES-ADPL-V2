package model;
public class Truck implements Vehicle {
    private boolean engineStatus = false;
    private boolean frontLampStatus = false;

    public void startEngine() {
        if(engineStatus == false){
            System.out.println("Mesin truk menyala");
            engineStatus = true;
        }
        else{
            System.out.println("Mesin truk sudah menyala!");
        }
    }

    public void stopEngine() {
        if(engineStatus == true){
            System.out.println("Mesin truk mati");  
            engineStatus = false;
        }
        else{
            System.out.println("Mesin truk sudah mati!");
        }
    }

    public void drive() {
        if (engineStatus)
            System.out.println("Truk sedang melaju");
        else System.out.println("Mesin truk masih mati");
    }
    public void reverse() {
        if (engineStatus)
            System.out.println("Truk berjalan mundur");
        else System.out.println("Mesin truk masih mati");
        
    }

    public void turnLeft() {
        System.out.println("Truk belok kiri");
    }

    public void turnRight() {
        System.out.println("Truk belok kanan");
    }

    @Override
    public void honk() {
        System.out.println("Truk membunyikan klakson");
    }

    @Override
    public void turnOffFrontLamp() {
        if(frontLampStatus == true){
            System.out.println("Lampu depan truk mati");
            frontLampStatus = false;
        }
        else{
            System.out.println("Lampu depan truk sudah mati!");
        }
    }

    @Override
    public void turnOnFrontLamp() {
        if(frontLampStatus == false){
            System.out.println("Lampu depan truk menyala");
            frontLampStatus = true;
        }
        else{
            System.out.println("Lampu depan truk sudah menyala!");
        }
    }

    @Override
    public void display() {
        System.out.println("Truk berhasil dibuat");
    }
}