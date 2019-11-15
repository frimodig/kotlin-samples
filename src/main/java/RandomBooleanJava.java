import java.util.Random;

public class RandomBooleanJava {
    private Random random = new Random();

    public Boolean next() {
        if (random.nextBoolean()) {
            return random.nextBoolean();
        }
        return null;
    }
}
