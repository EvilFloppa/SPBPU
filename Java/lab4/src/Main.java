import java.security.InvalidParameterException;

public class Main {



    public static void main(String[] args){

        int number = 1;
        try{
            number = Integer.parseInt(args[0]);
            if(number < 0){
                throw new InvalidParameterException("Wrong seedlings amount!");
            }
        }
        catch (Exception e){
            e.getLocalizedMessage();
        }

        Seedling[] seedlings = new Seedling[number];
        for (int i = 0; i < number; i++) {
            seedlings[i] = new Seedling();
        }


        System.out.print("Current seedlings' state: [ ");
        for (Seedling one : seedlings) {
            System.out.print(one + ", ");
        }
        System.out.print("]\n");


        Thread pan = new Thread(new Pan(number, seedlings));
        pan.start();

    }

}
