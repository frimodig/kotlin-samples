import java.util.stream.LongStream;

public class StringsJava {

    public String concatenate(String value1, Double value2) {
        return "This String is created with concatenation to include values " +
                value1 + " and " + Math.sqrt(value2) + ".";
    }

    public String format(String value1, Double value2) {
        return String.format("This String is created with formatter to include values %s and %f.",
                value1, Math.sqrt(value2));
    }

    public String multilineWithSpecialCharacters() {
        return "\tThis String has multiple lines with tabs\n" +
                "\tplus some potentially difficult characters\n" +
                "\tsuch as $, \\, and  \" .";
    }
}
