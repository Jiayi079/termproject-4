import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface MyFilter{
    // Single int as input, Boolean as output
    Boolean test(Integer a);
}

public class FilterExample {

    public static void main(String[] args) {
        List<Integer> myList = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(myList);

        System.out.println(doFilter(myList, a -> a > 5));
        System.out.println(doFilter(myList, a -> a < 5));
        System.out.println(doFilter(myList, FilterExample::methodFilter));
    }

    static Boolean methodFilter(Integer num){
        Boolean result = num % 2 == 0;
        System.out.println("MethodFilter being called with input = " + num + " result = " + result);
        return result;
    }

    static List<Integer> doFilter(List<Integer> list, MyFilter filter) {
        List<Integer> filteredList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean pass = filter.test(list.get(i)); // checking if number matched requirements

            if (pass) {
                filteredList.add(list.get(i));
            }
        }
        return filteredList;
    }
}
