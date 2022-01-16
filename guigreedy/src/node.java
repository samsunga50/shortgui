import java.util.Random;

public class node {
    Random rand = new Random();

    public int x = rand.nextInt(600);
    public int y = rand.nextInt(600);
    public boolean pass = false;

    public node(){}

}
