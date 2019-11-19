import java.util.Random;

public class RandomBooleanJava {
    private Random random = new Random();

    private Boolean next() {
        if (random.nextBoolean()) {
            return random.nextBoolean();
        }
        return null;
    }

    private Boolean nextNonNull() {
        Boolean potentialNull = next();

        if (potentialNull == null) {
            return nextNonNull();
        }
        return potentialNull;
    }
}
