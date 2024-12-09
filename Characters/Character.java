import java.util.HashMap;

public class Character {
    private String name;
    private int health;
    private int strength;
    private int level;
    private HashMap<String, String> inventory = new HashMap<>();

    public int multiplier(int attack) {
        return (int)Math.round(attack*(1+(0.2)*(strength-1)));
    }

    public void attack(Character target) {
        if (inventory.get(0).equals(null)) {
            target.setHealth(target.getHealth() - multiplier(2));
        }
    }

    public void takeDamage(int amount) {
        this.health -= amount;
    }

    public void heal(int amount) {
        if (100-this.health <= amount) {
            this.health = 100;
        }
        else {
            this.health += amount;
        } 
    }
    
    public void levelUP() {
        this.level++;
    }
    
    // Constructor
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        inventory.put("weapon", null);
        inventory.put("shield", null);
        inventory.put("misc", null);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return this.strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return 
    }
}

