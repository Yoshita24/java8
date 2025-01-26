import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
      List<String> stringList = Arrays.asList("Apple","Mango","Banana","Grapes","Tomato","Apple");
      List<String> finalNames= stringList.stream().collect(Collectors.toList());
      System.out.println("Printing list : "+finalNames);

      List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

      List<Integer> evenNumbersList = numbers.stream()
                                            .filter(x -> x % 2 == 0).collect(Collectors.toList());
      System.out.println("Filtered Even number from list : "+evenNumbersList);

      Integer maxValueFromList = numbers.stream().max(Integer::compare).get();
      System.out.println("MaxValueFromList : "+maxValueFromList);

      List<String> upperCaseConvertedStringList = stringList.stream()
                                            .map(x -> x.toUpperCase()).collect(Collectors.toList());
      System.out.println("UpperCaseConvertedStringList : "+upperCaseConvertedStringList);

      Map<Integer,List<String>> groupStringByLength= stringList.stream()
                                                    .collect(Collectors.groupingBy(String::length));
      System.out.println("**IMP GroupStringByLength : "+groupStringByLength);

      Integer sumofNumbersInList = numbers.stream().reduce(Integer::sum).get();
      System.out.println("SumofNumbersInList : "+sumofNumbersInList);

      Map<String, Long> countWordOccurenceInList = stringList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
      System.out.println("**IMP CountWordOccurenceInList : "+countWordOccurenceInList);

      String StringListContentJoined = stringList.stream().collect(Collectors.joining(","));
      System.out.println("**IMP StringListContentJoined : "+StringListContentJoined);

      List<Employee> employeeList=Arrays.asList(
              new Employee("Deven",1000),
              new Employee("Rudresh",2000),
              new Employee("Yash",1500)
      );
      List<Employee> employeeListSortedBySalary = employeeList.stream().sorted((o1, o2) -> o1.salary - o2.salary).collect(Collectors.toList());
      System.out.println("**IMP EmployeeListSortedBySalary :"+employeeListSortedBySalary);


    }
}
