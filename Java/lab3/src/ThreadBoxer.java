import java.util.Scanner;

class ThreadBoxer implements Runnable{

    private CommonResource res;
    private int iterations;

    ThreadBoxer(CommonResource resource, int times){
        this.res = resource;
        this.iterations = times;
    }

    @Override
    public void run() {
        synchronized (res) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i <= iterations; i++) {

                String str = scanner.next();
                res.setMsg(str);
                System.out.println("String '" + str + "' was put into the box");

                res.notify();
                try {
                    res.wait();
                }
                catch (InterruptedException e){
                    System.out.println(e.getLocalizedMessage());
                }
            }

            res.notify();
        }
    }
}