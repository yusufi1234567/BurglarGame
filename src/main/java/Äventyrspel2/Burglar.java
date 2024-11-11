package Äventyrspel2;

public class Burglar {
    private int health;
    private boolean isDefeated;


    public Burglar() {
        this.health = 50;
        this.isDefeated = false;
    }
    public int getHealth() {
        return this.health;
    }



    public boolean isDefeated() {
        return isDefeated;
    }


    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDefeated = true;
        }
    }}
