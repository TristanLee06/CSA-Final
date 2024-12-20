import java.util.HashMap;

public class Knight extends Character {
    private int armor; 
    // Array will be [Durability, Damage]
    //Reasoning for hashmap: hashmap is the only way that I can allow my code to set specific values for types of items. for example,
    // a wooden sword has a damage value of 5, however this labeling is only possible by linking the values through a hashmap.
    //Now, to address this "int[]", it's crucial to include! why? well, i'm going insane rn since it's 1am, but basically I kind of needed this
    //because the sword has an associated durability and damage. To link these together an array is necessary. Position index 0 is durability
    // while position index 1 is the damage of the sword. 
    private HashMap<String, int[]> sword = new HashMap<>();
    private HashMap<String, Integer> shield = new HashMap<>();
    private String swordType;

    public Knight(String name, int health, int strength, int armor, String swordType, String shieldType) {
        super(name, health, strength);
        this.armor = armor;
        this.swordType = swordType;

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

    public int getArmor() {
        return this.armor;
    }

    public String getSwordType() {
        return this.swordType;
    }

    public void parryAttack(Character player) {
        if (this.sword.keySet().toArray()[0].equals("obsidian")) {
            player.setHealth(player.getHealth()-(int)(this.sword.get("obsidian")[1]*(1.0+0.1*this.strength)));
            int[] array = {this.sword.get("obsidian")[0]-1, this.sword.get("obsidian")[1]};
            this.sword.put("obsidian", array);
        }
        if (this.sword.keySet().toArray()[0].equals("diamond")) {
            player.setHealth(player.getHealth()-(int)(this.sword.get("diamond")[1]*(1.0+0.1*this.strength)));
            int[] array = {this.sword.get("diamond")[0]-1, this.sword.get("diamond")[1]};
            this.sword.put("diamond", array);
        }
        if (this.sword.keySet().toArray()[0].equals("iron")) {
            player.setHealth(player.getHealth()-(int)(this.sword.get("iron")[1]*(1.0+0.1*this.strength)));
            int[] array = {this.sword.get("iron")[0]-1, this.sword.get("iron")[1]};
            this.sword.put("iron", array);
        }
        if (this.sword.keySet().toArray()[0].equals("stone")) {
            player.setHealth(player.getHealth()-(int)(this.sword.get("stone")[1]*(1.0+0.1*this.strength)));
            int[] array = {this.sword.get("stone")[0]-1, this.sword.get("stone")[1]};
            this.sword.put("stone", array);
        }
        if (this.sword.keySet().toArray()[0].equals("wooden")) {
            player.setHealth(player.getHealth()-(int)(this.sword.get("wooden")[1]*(1.0+0.1*this.strength)));
            int[] array = {this.sword.get("wooden")[0]-1, this.sword.get("wooden")[1]};
            this.sword.put("wooden", array);
        }
    }

    public int attackDragon(int dragon) {
        if (this.sword.keySet().toArray()[0].equals("obsidian")) {
            dragon-= (int)(this.sword.get("obsidian")[1]*(1.0+0.1*this.strength));
            int[] array = {this.sword.get("obsidian")[0]-1, this.sword.get("obsidian")[1]};
            this.sword.put("obsidian", array);
        }
        if (this.sword.keySet().toArray()[0].equals("diamond")) {
            dragon -= (int)(this.sword.get("diamond")[1]*(1.0+0.1*this.strength));
            int[] array = {this.sword.get("diamond")[0]-1, this.sword.get("diamond")[1]};
            this.sword.put("diamond", array);
        }
        if (this.sword.keySet().toArray()[0].equals("iron")) {
            dragon -= (int)(this.sword.get("iron")[1]*(1.0+0.1*this.strength));
            int[] array = {this.sword.get("iron")[0]-1, this.sword.get("iron")[1]};
            this.sword.put("iron", array);
        }
        if (this.sword.keySet().toArray()[0].equals("stone")) {
            dragon -= (int)(this.sword.get("stone")[1]*(1.0+0.1*this.strength));
            int[] array = {this.sword.get("stone")[0]-1, this.sword.get("stone")[1]};
            this.sword.put("stone", array);
        }
        if (this.sword.keySet().toArray()[0].equals("wooden")) {
            dragon -= (int)(this.sword.get("wooden")[1]*(1.0+0.1*this.strength));
            int[] array = {this.sword.get("wooden")[0]-1, this.sword.get("wooden")[1]};
            this.sword.put("wooden", array);
        }
        return dragon;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
        "Armor: " + this.armor + '\n' + " Sword Type: " + this.swordType;
    }
}
