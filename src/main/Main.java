package main;
import java.util.Scanner;
import java.util.Vector;

import command.*;

import decorator.*;

import factory.*;

import model.*;


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
        String jenisVehicle = "";
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
                vehicle.display();
                jenisVehicle = "Mobil";
                loop = false;
            }
            else if(action == 2){
                vehicle = TruckFactory.getVehicle();
                vehicle.display();
                jenisVehicle = "Truck";
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
            System.out.printf("Tambahkan fitur tambahan pada %s anda? (Y/N): ", jenisVehicle);

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
        addModifAvailable();

        //modifiikasi vehicle
        if(wantToModif == true){
            while(loop && modif.size() > 1){
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
                    command.add("Nyalakan musik");
                    command.add("Matikan musik");
                }
                else if(modif.get(action) == "Air Conditioner"){
                    modifYangDiinginkan.add("Air Conditioner");
                    modif.remove("Air Conditioner");
                    command.add("Nyalakan AC");
                    command.add("Matikan AC");
                }
                else if(modif.get(action) == "Batalkan memodifikasi"){
                    loop = false;
                    continue;
                }

                loop2 = true;
                while(loop2 && modif.size() > 1){
                    System.out.printf("Tambahkan fitur tambahan lainnya pada %s anda? (Y/N): ", jenisVehicle);
        
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
            jenis = modifYangDiinginkan.get(i);

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
                    vd = new AirConditionerDecorator(vd);
                }
            }
        }

        //bikin remote
        RemoteControl remote = new RemoteControl();

        Vector<Command> commands = new Vector<>();

        int ctrIdx = 9;
        int idxMusic = 0;
        int idxAc = 0;
        
        if(vd == null){
            commands.add(new StartEngineCommand(vehicle));
            commands.add(new StopEngineCommand(vehicle));
            commands.add(new TurnRightCommand(vehicle));
            commands.add(new TurnLeftCommand(vehicle));
            commands.add(new DriveCommand(vehicle));
            commands.add(new ReverseCommand(vehicle));
            commands.add(new HonkCommand(vehicle));
            commands.add(new TurnOnFrontLamp(vehicle));
            commands.add(new TurnOffFrontLamp(vehicle));
        }
        else{
            commands.add(new StartEngineCommand(vd));
            commands.add(new StopEngineCommand(vd));
            commands.add(new TurnRightCommand(vd));
            commands.add(new TurnLeftCommand(vd));
            commands.add(new DriveCommand(vd));
            commands.add(new ReverseCommand(vd));
            commands.add(new HonkCommand(vd));
            commands.add(new TurnOnFrontLamp(vd));
            commands.add(new TurnOffFrontLamp(vd));
            for(int i = 0;i < modifYangDiinginkan.size();i++){
                jenis = modifYangDiinginkan.get(i);

                if(jenis.equals("MP3")){
                    commands.add(new PlayMusicCommand(vd));
                    commands.add(new StopMusicCommand(vd));
                    idxMusic = ctrIdx;
                    ctrIdx += 2;
                }
                else if(jenis.equals("Air Conditioner")){
                    commands.add(new TurnOnACCommand(vd));
                    commands.add(new TurnOffACCommand(vd));
                    idxAc = ctrIdx;
                    ctrIdx += 2;
                }
            }
        }

        loop = true;

        command.add("Selesai");

        boolean goToCommand = false;

        while(loop){
            System.out.printf("Cek fitur - fitur pada %s anda? (Y/N): ", jenisVehicle);

            yn = sc.next().charAt(0);
    
            System.out.println();
            if(yn == 'Y' || yn == 'y'){
                loop = false;
                goToCommand = true;
            }
            else if(yn == 'N' || yn == 'n'){
                loop = false;
                goToCommand = false;
            }
            else{
                System.out.println("Aksi tidak valid");
            }
        }

        loop = true;

        if(goToCommand == true){
            while(loop){
                // Menjalankan command
                showCommand();
                System.out.print("Pilih aksi : ");
    
                action = sc.nextInt();
    
                System.out.println();
    
                
                if(action == 1){
                    remote.setCommand(commands.get(0));
                    remote.pressButton();
                }
                else if(action == 2){
                    remote.setCommand(commands.get(1));
                    remote.pressButton();
                }
                else if(action == 3){
                    remote.setCommand(commands.get(2));
                    remote.pressButton();
                }
                else if(action == 4){
                    remote.setCommand(commands.get(3));
                    remote.pressButton();
                }
                else if(action == 5){
                    remote.setCommand(commands.get(4));
                    remote.pressButton();
                }
                else if(action == 6){
                    remote.setCommand(commands.get(5));
                    remote.pressButton();
                }
                else if(action == 7){
                    remote.setCommand(commands.get(6));
                    remote.pressButton();
                }
                else if(action == 8){
                    remote.setCommand(commands.get(7));
                    remote.pressButton();
                }
                else if(action == 9){
                    remote.setCommand(commands.get(8));
                    remote.pressButton();
                }
                else if(action - 1 == commands.size()){
                    break;
                }
                else if(action <= 0 || action > commands.size()){
                    System.out.println("Aksi tidak valid");
                }
                else if(modifYangDiinginkan.get(0).equals("MP3")){
                    if(command.get(action - 1).equals("Nyalakan musik")){
                        remote.setCommand(commands.get(idxMusic));
                        remote.pressButton();
                    }
                    else if(command.get(action - 1).equals("Matikan musik")){
                        remote.setCommand(commands.get(idxMusic+1));
                        remote.pressButton();
                    }
                    
                    else if(modifYangDiinginkan.size()==2){
                        if(command.get(action - 1).equals("Nyalakan AC")){
                            remote.setCommand(commands.get(idxAc));
                            remote.pressButton();
                        }
                        else if(command.get(action - 1).equals("Matikan AC")){
                            remote.setCommand(commands.get(idxAc + 1));
                            remote.pressButton();
                        }
                    }
                }
                else{
                    if(command.get(action - 1).equals("Nyalakan AC")){
                        remote.setCommand(commands.get(idxAc));
                        remote.pressButton();
                    }
                    else if(command.get(action - 1).equals("Matikan AC")){
                        remote.setCommand(commands.get(idxAc + 1));
                        remote.pressButton();
                    }
                    
                    else if(modifYangDiinginkan.size() == 2){
                        if(command.get(action - 1).equals("Nyalakan musik")){
                            remote.setCommand(commands.get(idxMusic));
                            remote.pressButton();
                        }
                        else if(command.get(action - 1).equals("Matikan musik")){
                            remote.setCommand(commands.get(idxMusic+1));
                            remote.pressButton();
                        }
                    }   
                }
            }
        }
        if(vd == null){
            vehicle.display();
        }
        else{
            vd.display();
        }
        System.out.println("TERIMA KASIH");
    }

    public static void addModifAvailable(){
        modif.add("MP3");
        modif.add("Air Conditioner");
        modif.add("Batalkan memodifikasi");
    }

    public static void showModif(){
        int ctr = 1;
        int i;
        System.out.println("LIST MODIFIKASI YANG DAPAT DILAKUKAN");
        for(i = 0;i < modif.size();i++){
            if(i == modif.size() - 1){
                System.out.printf("%d. Batalkan memodifikasi\n", ctr);
                break;
            }
            System.out.printf("%d. Tambahkan %s.\n", ctr, modif.get(i));
            ctr++;
        }
    }

    public static void addBasicCommand(){
        command.add("Nyalakan mesin");
        command.add("Matikan mesin");
        command.add("Belok kanan");
        command.add("Belok kiri");
        command.add("Jalan");
        command.add("Mundur");
        command.add("Bunyikan klakson");
        command.add("Nyalakan lampu depan");
        command.add("Matikan lampu depan");
    }

    public static void showCommand(){
        int ctr = 1;
        int i;
        System.out.println("LIST COMMAND YANG DAPAT DILAKUKAN");
        for(i = 0;i < command.size();i++){
            System.out.printf("%d. %s.\n", ctr, command.get(i));
            ctr++;
        }
    }
}
