package Äventyrspel2;
public class Resident {
    private int health;
    private boolean hasBaseballBat;
    private boolean hasGun;
    private boolean hasKnife;

    public Resident() {
        this.health = health;
        this.hasBaseballBat = false;
        this.hasGun = false;
        this.hasKnife = false;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;

    }


    public void pickUpBaseballBat() {
        this.hasBaseballBat = true;
    }

    public void pickUpGun() {
        this.hasGun = true;
    }

    public void pickUpKnife() {
        this.hasKnife = true;
    }


    public boolean hasBaseballBat() {
        return hasBaseballBat;
    }

    public boolean hasGun() {
        return hasGun;
    }

    public boolean hasKnife() {
        return hasKnife;
    }


    public void heal() {
        int healingAmount = 20;
        this.health += healingAmount;
        System.out.println("You healed yourself for " + healingAmount + " health points.");
        System.out.println("Current health: " + this.health);
    }
}
