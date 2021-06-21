public class Planter extends Thread {

    private AttentionFocus focus;
    private int number;
    private String name = "Andrzej";

    Planter(int number, AttentionFocus focus){
        this.number = number;
        this.setName(name);
        this.focus = focus;
    }

    @Override
    public void run() {
        synchronized (focus) {

            for (int i = 0; i < number; i++) {

                while (focus.seedling.getStatus() != SeedlingStatus.Placed) {
                    try {
                        focus.wait();
                    } catch (InterruptedException err) {
                        System.out.println(err.getLocalizedMessage());
                    }
                }

                focus.seedling.plant();
                System.out.println(name + " has planted the " + (i+1) + "th seedling.");
                focus.notifyAll();
            }

            System.out.println(name + " rests");
        }

    }
}
