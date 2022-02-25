import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class HelloWorld {

    public static void main(String args[]){
        System.out.println("Hello World");

        String string = "My String";
        var string1 = "Another String"; // always String
        // string1 = 123; // can't change type

        HelloWorld helloWorld = new HelloWorld();
        var helloWorld1 = new HelloWorld();

        // Functions
        Function<String,String> myFunction = a -> "Hello " + a;
        System.out.println(myFunction.apply("World"));

        BiFunction<String, Integer, String> myFunction2 = (input, count) -> {
            String out = "";
            for (int i = 0; i < count; i++) {
                out += input;
            }
            return out;
        };
        System.out.println(myFunction2.apply("*", 10));

        Predicate<Integer> filter = abc -> abc > 10;
        System.out.println(filter.test(8));
        System.out.println(filter.test(11));
    }

    // equivalent method
    public String myMethod(String a) {
        return "Hello" + a;
    }
}
