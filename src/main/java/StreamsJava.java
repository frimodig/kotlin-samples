import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamsJava {

    private List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Kotlin");
        list.add("java");
        list.add("Clojure");
        list.add(null);
        list.add("Scala");
        return list;
    }

    public List<String> filterNull() {
        return createList()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String find(String x) {
        return createList()
                .stream()
                .filter(x::equals)
                .findAny()
                .orElse(null);
    }

    public List<String> complicatedFind() {
        return createList()
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.toLowerCase().contains("j"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
    }
}
