import java.util.ArrayList;

public class Wizard extends Character {
    private int mana;

    public Wizard(String name, int health, int strength, int mana) {
        super(name, health, strength);
        this.mana = mana;
    }

    public void castSpell(Character target) {
        if (mana >= 10) {
            target.takeDamage(15);
            mana -= 10;
            System.out.println(getName() + " casts a spell on " + target.getName() + ", dealing 15 damage.");
        } else {
            System.out.println(getName() + " does not have enough mana to cast a spell.");
        }
    }

    public void protect(Character ally) {
        if (mana >= 5) {
            ally.heal(20);
            mana -= 5;
            System.out.println(getName() + " protects " + ally.getName() + " by restoring 20 health.");
        } else {
            System.out.println(getName() + " does not have enough mana to protect!");
        }
    }

    public void strengthen(Knight knight) {
        if (mana >= 15) {
            knight.setStrength(knight.getStrength() + 10);
            mana -= 15;
            System.out.println(getName() + " strengthens " + knight.getName() + ", increasing their strength!");
        } else {
            System.out.println(getName() + " does not have enough mana to strengthen a Knight.");
        }
    }

    public void campaignAction(Character dragon, ArrayList<Character> allies) {
        // Prioritize actions dynamically
        if (mana >= 15) {
            for (Character ally : allies) {
                if (ally instanceof Knight) {
                    strengthen((Knight) ally);
                    return;
                }
            }
        } else if (mana >= 10) {
            castSpell(dragon);
        } else if (mana >= 5) {
            for (Character ally : allies) {
                if (ally.getHealth() < 50) {
                    protect(ally);
                    return;
                }
            }
        } else {
            System.out.println(getName() + " is out of mana and cannot act this turn.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nMana: " + mana;
    }
}

