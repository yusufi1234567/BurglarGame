package Äventyrspel2;

import java.util.Scanner;

public class Directions {
    Scanner scanner = new Scanner(System.in);
    Resident resident;
    Burglar burglar;

    public Directions(Resident resident, Burglar burglar) {
        this.resident = resident;
        this.burglar = burglar;
    }

    private void continueExploring() {
        System.out.println("What do you want to do next?");
        System.out.println("1) Go back to Hall.");
        System.out.println("2) Stay in the current room.");
        String nextChoice = scanner.nextLine();

        if ("1".equals(nextChoice)) {
            goHall();
        } else if (!"2".equals(nextChoice)) {
            System.out.println("Invalid option. Please try again.");
            continueExploring();
        }
    }

    private void attackBurglar(String weapon) {
        int damage = 25;

        System.out.println("You attack the burglar with the " + weapon + "!");
        burglar.takeDamage(damage);


        System.out.println("The burglar now has " + burglar.getHealth() + " health left.");

        if (burglar.isDefeated()) {
            System.out.println("You have defeated the burglar!");
            System.out.println("Resident: I need to call the police! The burglar is down!");
            System.out.println("Police have arrived. The game is over.");
            System.exit(0);
        }
    }

    public void goBedroom() {
        System.out.println("You entered The Bedroom.");
        System.out.println("Options: 1) Look under the bed, 2) Go back to Hall.");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            if (!resident.hasKnife()) {
                System.out.println("You found a knife! Do you want to pick it up? (yes/no)");
                String pickUpChoice = scanner.nextLine();
                if ("yes".equalsIgnoreCase(pickUpChoice)) {
                    resident.pickUpKnife();
                    System.out.println("You picked up the knife.");
                    attackBurglar("knife");
                    goLivingroom();
                }
            }
        } else if ("2".equals(choice)) {
            goHall();
        } else {
            System.out.println("Invalid option. Please try again.");
        }

        continueExploring();
    }

    public void goLivingroom() {
        System.out.println("You entered The Livingroom.");
        System.out.println("Options: 1) Look behind the couch, 2) Go back to Hall.");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            if (!resident.hasBaseballBat()) {
                System.out.println("You found a baseball bat! Do you want to pick it up? (yes/no)");
                String pickUpChoice = scanner.nextLine();
                if ("yes".equalsIgnoreCase(pickUpChoice)) {
                    resident.pickUpBaseballBat();
                    System.out.println("You picked up the baseball bat.");
                    attackBurglar("baseball bat");
                    goKitchen();
                }
            }
        } else if ("2".equals(choice)) {
            goHall();
        } else {
            System.out.println("Invalid option. Please try again.");
        }

        continueExploring();
    }

    public void goKitchen() {
        System.out.println("You entered The Kitchen.");
        System.out.println("Options: 1) Open the fridge, 2) Check the cupboards, 3) Go back to Hall.");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            System.out.println("There is only food in the Fridge.");
        } else if ("2".equals(choice)) {
            if (!resident.hasKnife()) {
                System.out.println("You found a knife in the cupboard! Do you want to pick it up? (yes/no)");
                String pickUpChoice = scanner.nextLine();
                if ("yes".equalsIgnoreCase(pickUpChoice)) {
                    resident.pickUpKnife();
                    System.out.println("You picked up the knife.");
                    attackBurglar("knife");
                    goBathroom();
                }
            }
        } else if ("3".equals(choice)) {
            goHall();
        } else {
            System.out.println("Invalid option. Please try again.");
        }

        continueExploring();
    }

    public void goBathroom() {
        System.out.println("You entered The Bathroom.");
        System.out.println("Options: 1) Check the cabinet, 2) Go back to Hall.");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            System.out.println("You found some bandages in the cabinet! Do you want to heal yourself? (yes/no)");
            String healChoice = scanner.nextLine();
            if ("yes".equalsIgnoreCase(healChoice)) {
                resident.heal();
            }
        } else if ("2".equals(choice)) {
            goHall();
        } else {
            System.out.println("Invalid option. Please try again.");
        }

        continueExploring();
    }

    public void goHall() {
        System.out.println("You are back in The Hall.");
        System.out.println("Options: 1) Bedroom, 2) Kitchen, 3) Livingroom, 4) Bathroom, 5) Stop");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                goBedroom();
                break;
            case "2":
                goKitchen();
                break;
            case "3":
                goLivingroom();
                break;
            case "4":
                goBathroom();
                break;
            case "5":
                System.out.println("Game Over. You decide to stop exploring.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                goHall();
                break;
        }
    }
}
