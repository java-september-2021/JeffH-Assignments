public class Bat extends Mammal {
    
    public Bat () {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("*swoosh*");
        this.energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("The bat ate some humans.");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("*fire roars*");
        this.energyLevel -= 100;
    }
}