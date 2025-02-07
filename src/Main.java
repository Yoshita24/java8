import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream().map(x -> 5 * x).collect(Collectors.toList());
        System.out.println(collect);
        A a = new A();
      //  a.method(null);
    }
}
class Parent
{
    public void m1()
    {

    }
}
class Child extends Parent
{
    public void m1() throws ArrayIndexOutOfBoundsException
    {

    }
}

class A
{
    void method(Integer i)
    {
        System.out.println("Inside integer");
    }
    void method(String i)
    {
        System.out.println("Inside String");
    }
}
