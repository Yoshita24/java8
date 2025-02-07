import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharacterFrequency {
    public static void main(String[] args) {
        String input ="yoshita";
     Map<String,Long> mapCount= Arrays.stream(input.split("")).collect(
              Collectors.groupingBy(Function.identity(),Collectors.counting())
      );
     System.out.println("MapCount : "+mapCount);
    }
}
