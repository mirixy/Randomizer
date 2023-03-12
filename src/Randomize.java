import java.util.Arrays;
import java.util.Random;

public class Randomize extends Classmates {
    String nm = "";
    Randomize() {
        Random rand = new Random();
        System.out.println(count);
        int randomNr = rand.nextInt(count);
        System.out.println(randomNr);
        System.out.println(names[randomNr]);
        nm = names[randomNr];
    }
}
