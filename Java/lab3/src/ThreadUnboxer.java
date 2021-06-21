public class ThreadUnboxer implements Runnable {

    private CommonResource res;
    private int iterations;

    ThreadUnboxer(CommonResource resource, int times){
        this.res = resource;
        this.iterations = times;
    }

    @Override
    public void run() {
        synchronized (res) {

            if (res.getMsg() == null){
                try{
                    res.wait();
                }
                catch (InterruptedException e){
                    System.out.println(e.getLocalizedMessage());
                }
            }

            for (int i = 0; i <= iterations; i++) {

                System.out.println("String '" + res.getMsg() + "' was taken from the box");

                res.notify();

                try {
                    res.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }


    }
}
