package main;
import java.util.Scanner;
import java.util.Vector;

import command.Command;
import command.RemoteControl;
import command.StartEngineCommand;
import command.StopEngineCommand;
import decorator.AirConditionerDecorator;
import decorator.MP3Decorator;
import model.Car;
import factory.CarFactory;
import factory.TruckFactory;
import model.Vehicle;
import decorator.VehicleDecorator;

public class Main {
    public static Vector<String> modif;
    public static Vector<String> command;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("SELAMAT DATANG DI TOKO KENDARAAN KAPI");
        System.out.println("LIST AKSI YANG DAPAT DILAKUKAN");
        System.out.println("1. Pesan Mobil");
        System.out.println("2. Pesan Truck");

        boolean loop = true;
        String jenis = "";
        Vehicle vehicle = new Car();

        int action;
        while(loop){
            System.out.print("Pilih aksi : ");

            action = sc.nextInt();

            System.out.println();

            // Membuat kendaraan dengan metode factory
            if(action == 1){
                vehicle = CarFactory.getVehicle();
                System.out.println("Mobil telah dibuat");
                jenis = "Mobil";
                loop = false;
            }
            else if(action == 2){
                vehicle = TruckFactory.getVehicle();
                System.out.println("Truck telah dibuat");
                jenis = "Truck";
                loop = false;
            }
            else{
                System.out.println("Aksi tidak valid");
            }
        }

        loop = true;

        boolean wantToModif = true;

        char yn = 'Y';

        command = new Vector<>();
        addBasicCommand();

        while(loop){
            System.out.printf("Tambahkan fitur tambahan pada %s anda? (Y/N): ", jenis);

            yn = sc.next().charAt(0);
    
            System.out.println();
            if(yn == 'Y' || yn == 'y'){
                loop = false;
                wantToModif = true;
            }
            else if(yn == 'N' || yn == 'n'){
                loop = false;
                wantToModif = false;
            }
            else{
                System.out.println("Aksi tidak valid");
            }
        }
        
        loop = true;

        boolean loop2 = true;

        Vector<String> modifYangDiinginkan = new Vector<>();

        modif = new Vector<>();
        addModif();

        //modifiikasi vehicle
        if(wantToModif == true){
            while(loop && modif.size() > 0){
                showModif();

                System.out.print("Pilih modifikasi : ");
    
                action = sc.nextInt() - 1;
    
                System.out.println();

                if(action >= modif.size() || action < -1){
                    System.out.println("Aksi tidak valid");
                    continue;
                }
                
                if(modif.get(action) == "MP3"){
                    modifYangDiinginkan.add("MP3");
                    modif.remove("MP3");
                }
                else if(modif.get(action) == "Air Conditioner"){
                    modifYangDiinginkan.add("Air Conditioner");
                    modif.remove("Air Conditioner");
                }

                loop2 = true;
                while(loop2 && modif.size() > 0){
                    System.out.printf("Tambahkan fitur tambahan lainnya pada %s anda? (Y/N): ", jenis);
        
                    yn = sc.next().charAt(0);
            
                    System.out.println();
                    if(yn == 'Y' || yn == 'y'){
                        loop2 = false;
                    }
                    else if(yn == 'N' || yn == 'n'){
                        loop2 = false;
                        loop = false;
                    }
                    else{
                        System.out.println("Aksi tidak valid");
                    }
                }
            }
        }

        VehicleDecorator vd = null;

        for(int i = 0;i < modifYangDiinginkan.size();i++){
            jenis = modifYangDiinginkan.firstElement();
            modifYangDiinginkan.remove(0);

            if(jenis.equals("MP3")){
                if(i == 0){
                    vd = new MP3Decorator(vehicle);
                }
                else{
                    vd = new MP3Decorator(vd);
                }
            }
            else if(jenis.equals("Air Conditioner")){
                if(i == 0){
                    vd = new AirConditionerDecorator(vehicle);
                }
                else{
                    vd = new MP3Decorator(vd);
                }
            }
        }

        //bikin remote
        RemoteControl remote = new RemoteControl();

        // Membuat command
        Command startEngine;
        Command stopEngine;
        
        if(vd == null){
            startEngine = new StartEngineCommand(vehicle);
            stopEngine = new StopEngineCommand(vehicle);
        }
        else{
            startEngine = new StartEngineCommand(vd);
            stopEngine = new StopEngineCommand(vd);
        }


        loop = true;
        while(loop){
            // Menjalankan command
            System.out.println("LIST COMMAND YANG DAPAT DILAKUKAN");
            System.out.println("1. Nyalakan mesin");
            System.out.println("2. Matikan mesin");
            System.out.println("3. Selesai");
            System.out.print("Pilih aksi : ");

            action = sc.nextInt();

            System.out.println();

            // Membuat kendaraan dengan metode factory
            if(action == 1){
                remote.setCommand(startEngine);
                remote.pressButton();
            }
            else if(action == 2){
                remote.setCommand(stopEngine);
                remote.pressButton();
            }
            else if(action == 3){
                break;
            }
            else{
                System.out.println("Aksi tidak valid");
            }
        }

        System.out.println("TERIMA KASIH");
    }

    public static void showModif(){
        int ctr = 1;
        int i;
        System.out.println("LIST MODIFIKASI YANG DAPAT DILAKUKAN");
        for(i = 0;i < modif.size();i++){
            System.out.printf("%d. Tambahkan %s.\n", ctr, modif.get(i));
            ctr++;
        }
    }

    public static void addBasicCommand(){
        command.add("Nyalakan mesin");
        command.add("Matikan mesin");
        command.add("Bunyikan klakson");
        command.add("Nyalakan lampu depan");
        command.add("Matikan lampu depan");
    }

    public static void addModif(){
        modif.add("MP3");
        modif.add("Air Conditioner");
    }

    public static void showCommand(){
        int ctr = 1;
        int i;
        System.out.println("LIST COMMAND YANG DAPAT DILAKUKAN");
        for(i = 0;i < command.size();i++){
            System.out.printf("%d. Tambahkan %s.\n", ctr, modif.get(i));
            ctr++;
        }
    }
}
