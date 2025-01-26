import java.util.List;

public class Employee {
    String name;
    int salary;
    String department;
    int age;
    List<String> city;

    public Employee(String name, int salary, String department, int age, List<String> city) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
