import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RandomBooleanJavaTest {

    private RandomBooleanJava random = new RandomBooleanJava();


    @Test
    void testNull() {
       assertThat(random.next(), notNullValue());
    }

    @Test
    void testEnsureNotNull() {
        Boolean value = random.next();
        if (value == null) {
            value = false;
        }

        assertThat(value, notNullValue());
    }
}