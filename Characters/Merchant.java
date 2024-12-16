import java.util.ArrayList;

public class Merchant extends Character {
    private ArrayList<String> inventory = new ArrayList<>();

    public Merchant(String name, int health, int strength) {
        super(name, health, strength);
        inventory.add("Potion");
        inventory.add("Food");
    }

    public void trade(String item) {
        if (inventory.contains(item)) {
            System.out.println(getName() + " traded " + item + ".");
            inventory.remove(item);
        } else {
            System.out.println(item + " is not available.");
        }
    }
    @Override
    public String toString() {
        return super.toString() + "\nInventory: " + inventory;
    }
}
