package Äventyrspel2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Resident resident = new Resident();
        Burglar burglar = new Burglar();
        Directions directions = new Directions(resident, burglar);

        System.out.println("**** Welcome to The Burglary ****");
        System.out.println("In this game, you are getting robbed, so you must protect yourself and the house.");
        System.out.println("Press ENTER to start the game!");
        scanner.nextLine();

        System.out.println("You are in the Hall. Do you want to enter a room? Bedroom/Kitchen/Livingroom/Bathroom or type 'Stop' to quit.");

        boolean going = true;
        while (going) {
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "Bedroom":
                    directions.goBedroom();
                    break;
                case "Livingroom":
                    directions.goLivingroom();
                    break;
                case "Kitchen":
                    directions.goKitchen();
                    break;
                case "Bathroom":
                    directions.goBathroom();
                    break;
                case "Stop":
                    going = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
