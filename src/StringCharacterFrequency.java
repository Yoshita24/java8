import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharacterFrequency {
    public static void main(String[] args) {
        String input ="yoshita";
     Map<String,Long> mapCount= Arrays.stream(input.split("")).collect(
              Collectors.groupingBy(Function.identity(),Collectors.counting())
      );
     System.out.println("MapCount : "+mapCount);

     //Assume you have list of employee in various dept, WAP to find highest paid employee from each dept

     List<Emp> empList =Arrays.asList(
             new Emp(1,"Deven",5000,"Dev"),
             new Emp(2,"Yoshita",10000,"Acc"),
             new Emp(3,"Rudra",15000,"Dev"),
             new Emp(4,"Yogesh",25000,"Dev")
     );
        // Group by department and get highest-paid employee in each
        Map<String, Emp> highestPaidByDept = empList.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDepatmentName,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Emp::getSalary)),
                                Optional::get // Get the employee with max salary
                        )
                ));

        highestPaidByDept.forEach((dept, emp) ->
                System.out.println("Highest Paid in " + dept + ": " + emp));

        // Using toMap() to find the highest-paid employee in each department
        Map<String, Emp> highestPaidByDept1 = empList.stream()
                .collect(Collectors.toMap(
                        Emp::getDepatmentName,  // Key: Department
                        emp -> emp,  // Value: Employee object
                        (emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1 : emp2 // Merge logic
                ));

        // Print the result
        highestPaidByDept.forEach((dept, emp) ->
                System.out.println("***Highest Paid in " + dept + ": " + emp));
    }
}
class Emp
{
    int id;
    String name;
    int salary;
    String depatmentName;

    public Emp(int id, String name, int salary, String depatmentName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.depatmentName = depatmentName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", depatmentName='" + depatmentName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }
}