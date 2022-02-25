import java.util.function.Function;

enum Color{
    RED,
    YELLOW,
    BLUE
}

@FunctionalInterface // now implement with a lambda
interface MyInterface{
    Integer doSomething(Color c);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //MyInterface myInterface = new MyInterface(); // can't do this because methods are abstract (not implemented)
        MyInterface myInterface = c -> c.ordinal();
        System.out.println(myInterface.doSomething(Color.YELLOW));
        MyInterface myInterface1 = abc -> (int)Math.floor(Math.random()*100);
        System.out.println(myInterface1.doSomething(Color.RED));

        doStuff(a -> a + "world 1");
        doStuff(FunctionalInterfaceDemo::sayHello); // passing in ref to existing method
        doStuff(a -> {
            System.out.println("anonymous lambda being called 2");
            return a + "world 3";
        });
    }

    // input is not a value, its something that can run
    // run something and pass it "Hello"
    public static void doStuff(Function<String, String> function) {
        System.out.println("Do stuff being called 4");
        String result = function.apply("hello 5");
        System.out.println(function.apply("hello 6"));
    }

    // a-> a + " world"
    public static String sayHello(String a) {
        System.out.println("say hello (method version) being called 7");
        return a + " world! 8";
    }

}
