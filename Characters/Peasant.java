public class Peasant extends Character {
    private int harvestedGoods;

    public Peasant(String name, int health, int strength, int harvestedGoods) {
        super(name, health, strength);
        this.harvestedGoods = harvestedGoods;
    }

    public void trade() {
        System.out.println(getName() + " trades " + harvestedGoods + " goods.");
    }
    @Override
    public String toString() {
        return super.toString() + '\n' + "Harvested Goods: " + harvestedGoods;
    }
}
