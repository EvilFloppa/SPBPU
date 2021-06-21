public class Pan extends Thread {

    private int number;
    private Seedling[] seedlings;

    Pan(int number, Seedling[] seedlings){
        this.number = number;
        this.seedlings = seedlings;
    }

    @Override
    public void run() {
        System.out.println("\nToday our Pan wants to plant " + number + " seedlings.\n");

        AttentionFocus focus = new AttentionFocus(seedlings[0]);

        Thread tier = new Thread(new Tier(number, focus));
        Thread digger = new Thread(new Digger(number, focus));
        Thread planter = new Thread(new Planter(number, focus));

        synchronized (focus) {

            planter.start();
            digger.start();
            tier.start();

            for (int i = 1; i < number; i++) {

                while (focus.seedling.getStatus() != SeedlingStatus.Planted){
                    try{
                        focus.wait();
                    }
                    catch (InterruptedException err){
                        System.out.println(err.getLocalizedMessage());
                    }
                }

                focus.setFocus(seedlings[i]);
                System.out.println();
                focus.notifyAll();

            }

            while (focus.seedling.getStatus() != SeedlingStatus.Planted) {
                try {
                    focus.wait();
                } catch (InterruptedException err) {
                    System.out.println(err.getLocalizedMessage());
                }
            }

                System.out.print("\nCurrent seedlings' state: [ ");
                for (Seedling one : seedlings) {
                    System.out.print(one + ", ");
                }
                System.out.print("]\nPan is pleased\n");


        }
    }
}
