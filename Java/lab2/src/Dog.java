public class Dog extends Creature implements Creep {


    @Override
    public void creep() {
        System.out.println("I can creep");
    }

    @Override
    public void whoAmI() {
        System.out.println("I am a doggie");
    }
}
