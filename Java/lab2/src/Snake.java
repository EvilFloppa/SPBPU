public class Snake extends Creature implements Wriggle {

    @Override
    public void whoAmI(){
        System.out.println("I am a snakkie");
    }

    @Override
    public void creep(){
        System.out.println("I cannot creep");
    }

}
