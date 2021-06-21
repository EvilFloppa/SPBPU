public final class Seedling {

    volatile private  SeedlingStatus status;

    Seedling(){
        this.status = SeedlingStatus.Awaits;
    }

    public synchronized void tieUp(){
        if (status == SeedlingStatus.Awaits){
            status = SeedlingStatus.TiedUp;
        }
        else
        {
            System.out.println("Wrong order!");
        }
    }

    public synchronized void place(){
        if (status == SeedlingStatus.TiedUp){
            status = SeedlingStatus.Placed;
        }
        else
        {
            System.out.println("Wrong order!");
        }
    }

    public synchronized void plant(){
        if (status == SeedlingStatus.Placed){
            status = SeedlingStatus.Planted;
        }
        else
        {
            System.out.println("Wrong order!");
        }
    }

    public synchronized SeedlingStatus getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return this.status.toString();
    }
}
