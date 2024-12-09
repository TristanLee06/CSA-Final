import java.util.HashMap;
import java.util.List;

public class Knight extends Character {
    private int armor; 
    // Array will be [Durability, Damage]
    private HashMap<String, int[]> sword = new HashMap<>();
    private HashMap<String, Integer> shield = new HashMap<>();

    public Knight(String name, int health, int armor, String swordType, String shieldType) {
        super(name, health);
        this.armor = armor;

        shieldType = shieldType.toLowerCase();
        swordType = swordType.toLowerCase();
        if (shieldType.equals("wooden")) {
            shield.put(shieldType, 25);
        }
        else if (shieldType.equals("iron")) {
            shield.put(shieldType, 50);
        }
        else {
            System.out.println(shieldType + " is not a valid shield type!");
        }
        if (swordType.equals("obsidian")) {
            int[] array = {10, 30};
            sword.put(swordType, array);
        }
        else if (swordType.equals("diamond")) {
            int[] array = {8, 25};
            sword.put(swordType, array);
        }
        else if (swordType.equals("iron")) {
            int[] array = {6, 15};
            sword.put(swordType, array);
        }
        else if (swordType.equals("stone")) {
            int[] array = {4, 10};
            sword.put(swordType, array);
        }
        else if (swordType.equals("wooden")) {
            int[] array = {2, 5};
            sword.put(swordType, array);
        }
        else {
            System.out.println(swordType + " is not a valid sword type!");
        }
    }

    public void protect(Character ally) {
        if (this.shield.keySet().toArray()[0].equals("wooden")) {
            // idk yet
        }
        if (this.shield.keySet().toArray()[0].equals("iron")) {
            // idk yet
        }
    }
    public void parryAttack(Character player) {
        if (this.sword.keySet().toArray()[0].equals("obsidian")) {
            player.setHealth(player.getHealth()-this.sword.get("obsidian")[1]);
            int[] array = {this.sword.get("obsidian")[0]-1, this.sword.get("obsidian")[1]};
            this.sword.put("obsidian", array);
        }
        if (this.sword.keySet().toArray()[0].equals("diamond")) {
            player.setHealth(player.getHealth()-this.sword.get("diamond")[1]);
            int[] array = {this.sword.get("diamond")[0]-1, this.sword.get("diamond")[1]};
            this.sword.put("diamond", array);
        }
        if (this.sword.keySet().toArray()[0].equals("iron")) {
            player.setHealth(player.getHealth()-this.sword.get("iron")[1]);
            int[] array = {this.sword.get("iron")[0]-1, this.sword.get("iron")[1]};
            this.sword.put("iron", array);
        }
        if (this.sword.keySet().toArray()[0].equals("stone")) {
            player.setHealth(player.getHealth()-this.sword.get("stone")[1]);
            int[] array = {this.sword.get("stone")[0]-1, this.sword.get("stone")[1]};
            this.sword.put("stone", array);
        }
        if (this.sword.keySet().toArray()[0].equals("wooden")) {
            player.setHealth(player.getHealth()-this.sword.get("wooden")[1]);
            int[] array = {this.sword.get("wooden")[0]-1, this.sword.get("wooden")[1]};
            this.sword.put("wooden", array);
        }
    }

    public String toString() {
        return "Armor: " + this.armor + " Sword Type: " + this.swordType;
    }
}
