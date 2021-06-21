import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        int arrSize = Integer.parseInt(args[0]);
        System.out.printf("Creature array size = %d\n\n", arrSize);

        ArrayList<Creep> array = new ArrayList<Creep>(arrSize);

        for (int i = 0; i < (arrSize / 2); i++) {
            array.add(new Dog());
            array.add(new Snake());
        }

        if (arrSize % 2 == 1){
            array.add(new Dog());
        }

        for (int i = 0; i < arrSize; i++) {
            System.out.printf("<%dth creature>\n", i + 1);
            array.get(i).whoAmI();
            array.get(i).creep();
            System.out.println();

        }

    }

}
