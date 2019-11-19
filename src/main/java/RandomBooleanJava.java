import java.util.Optional;
import java.util.Random;

public class RandomBooleanJava {
    private final Random random = new Random();

    public Boolean next() {
        if (random.nextBoolean()) {
            return random.nextBoolean();
        }
        return null;
    }

    public Boolean nextNonNull() {
        Boolean potentialNull = next();

        if (potentialNull == null) {
            return false;
        }
        return potentialNull;
    }

    ////// Using optionals

    public Optional<Boolean> optionalNext() {
        return Optional.of(next());
    }

    public Boolean nextNotNullFromOptional() {
        return optionalNext().orElse(false);
    }
}
