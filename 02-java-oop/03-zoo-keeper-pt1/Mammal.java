public class Mammal {
    public int energyLevel = 100;

    public int displayEnergy() {
        System.out.println("The animals current energy is " + this.energyLevel);
        return this.energyLevel;
    }
}