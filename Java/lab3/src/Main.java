import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {

        CommonResource box = new CommonResource(null);
        int iterations = 0;

        try {
            iterations = Integer.parseInt(args[0]);
            if (iterations < 0){
                throw new InvalidParameterException("Parameter must be a positive number!");
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            //return;
        }

        System.out.println(iterations + " iterations detected");

        Thread boxer = new Thread(new ThreadBoxer(box, iterations));
        boxer.setName("Boxer");
        Thread unboxer = new Thread(new ThreadUnboxer(box, iterations));
        unboxer.setName("Unboxer");


        boxer.start();
        unboxer.start();

/*
        for (int i = 0; i < iterations; i++){
            System.out.println("Iteration " + (iterations));
            boxer.start();
            unboxer.start();
            /*
            boxer.notify();
            unboxer.notify();

        }
*/

    }
}
