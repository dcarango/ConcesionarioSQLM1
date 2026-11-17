package ui;

import database.StructureDB;
import myLib.UserMethods;
import java.util.Scanner;


public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private boolean exitMenu = false;

    public void showMenu(){
        UserMethods userMethods = new UserMethods();
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Create data base");
            userMethods.myPrinter("2. Delete data base");
            userMethods.myPrinter("3. Show sales");
            userMethods.myPrinter("4. Delete client");
            userMethods.myPrinter("0. Exit.");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        UserMethods userMethods = new UserMethods();
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                StructureDB structureDB = new StructureDB();
                userMethods.myPrinter(structureDB.loadScript());
            }
            case "2" -> {
                StructureDB structureDB = new StructureDB();
                userMethods.myPrinter(structureDB.deleteDatabase());
            }
            case "3" -> {

            }
            case "4" -> {
            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
