import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Name is null"));
        System.out.println(name.orElseGet(() -> "Name is nulll"));
    }
}
