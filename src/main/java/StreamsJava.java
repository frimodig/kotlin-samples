import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamsJava {

    private List<String> list = Arrays.asList("Kotlin", "Java", "Clojure", null, "Scala");

    public List<String> filterNull() {
        return list
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String find(String x) {
        return list
                .stream()
                .filter(x::equals)
                .findAny()
                .orElse(null);
    }

    public List<String> complicatedFind() {
        return list
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.toLowerCase().contains("j"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
    }
}
