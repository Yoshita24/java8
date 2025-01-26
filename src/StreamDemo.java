import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
      List<String> stringList = Arrays.asList("Apple","Mango","Banana","Grapes","Tomato","Apple");
      List<String> finalNames= stringList.stream().collect(Collectors.toList());
      System.out.println("Printing list : "+finalNames);

      List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,19);

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
              new Employee("Deven",1000,"IT"),
              new Employee("Rudresh",2000,"IT"),
              new Employee("Yash",1500,"IT")
      );
      List<Employee> employeeListSortedBySalary = employeeList.stream().sorted((o1, o2) -> o1.salary - o2.salary).collect(Collectors.toList());
      System.out.println("**IMP EmployeeListSortedBySalary : "+employeeListSortedBySalary);

      String input="deven";
       Character firstNonRepeatedCharacterInString=     input.chars().mapToObj(c->(char)c)
                    .filter(c->input.indexOf(c)==input.indexOf(c)).findFirst().orElse(null);
        System.out.println("**IMP firstNonRepeatedCharacterInString : "+firstNonRepeatedCharacterInString);
        /*input.indexOf(c):
        Returns the index of the first occurrence of the character c in the string input.
        input.lastIndexOf(c):
        Returns the index of the last occurrence of the character c in the string input.
        indexOf(c) == lastIndexOf(c):
        This checks if the first occurrence of the character is the same as the last occurrence.
        If this condition is true, it means the character appears only once in the string.*/

        int sumOfNumbersUsingReduce =numbers.stream().reduce(0,Integer::sum);
        System.out.println("SumOfNumbersUsingReduce : "+sumOfNumbersUsingReduce);

        List<Integer> distinctListOfNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("**IMP DistinctListOfNumbers : "+distinctListOfNumbers);

        List<String> listOfStringStartingWithACharacter = stringList.stream()
                .filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println("listOfStringStartingWithACharacter : "+listOfStringStartingWithACharacter);

        List<String> stringSortedInAlphabeticOrder=stringList.stream().
                sorted().collect(Collectors.toList());
        System.out.println("**IMP stringSortedInAlphabeticOrder : "+stringSortedInAlphabeticOrder);

        List<String> stringSortedInReverseOrder=stringList.stream().
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("**IMP stringSortedInReverseOrder : "+stringSortedInReverseOrder);

        List<List<Integer>> nestedintegerList=Arrays.asList(
                Arrays.asList(1,2,5),
                Arrays.asList(6,7),
                Arrays.asList(3,4)
                );
        List<Integer> flatenedIntegetList = nestedintegerList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("**IMP flatenedIntegetList : "+flatenedIntegetList);

        Map<Boolean, List<Integer>> evenAndOddNumbersGroupedUsingPartitionBy = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("**IMP evenAndOddNumbersGroupedUsingPartitionBy : "+evenAndOddNumbersGroupedUsingPartitionBy);

        Integer secondHighestNumberFromList = numbers.stream()
                .sorted((o1, o2) -> o2 - o1).skip(1).findFirst().get();
        System.out.println("**IMP secondHighestNumberFromList : "+secondHighestNumberFromList);

        String inputString="deven";
        Map<Character, Long> countFrequencyOfEachCharacterFromString = inputString.chars()
                .mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println("**IMP countFrequencyOfEachCharacterFromString : "+countFrequencyOfEachCharacterFromString);

       boolean checkIfNumbersInListAreGreaterThan15= numbers.stream().allMatch(n->n>15);
        System.out.println("**checkIfNumbersInListAreGreaterThan15 : "+checkIfNumbersInListAreGreaterThan15);

        List<Employee> employeeList1=Arrays.asList(
                new Employee("Deven",1000,"IT"),
                new Employee("Rudresh",2000,"COMP"),
                new Employee("Yash",1500,"IT"),
                new Employee("Ramesh",1500,"COMP")
        );
     System.out.println("**IMP groupedByDepartment");
    Map<String,List<Employee>> groupedByDepartment = employeeList1.stream().collect(Collectors.groupingBy(emp->emp.department));
        groupedByDepartment.forEach((department,employeelists)->
        {
            System.out.println("for Department : "+department+" Employee list : "+employeelists);
        });

    String sentence="Hello this is yoshita here Hello";
    Map<String, Long> wordCountFromSentence = Arrays.stream(sentence.split(" "))
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

    System.out.println("**IMP wordCountFromSentence : "+wordCountFromSentence);

   String longestWord = stringList.stream().max(Comparator.comparingInt(String::length)).orElse(null);
    System.out.println("**IMP longestWord : "+longestWord);

    List<Integer> list1=Arrays.asList(1,2,3);
    List<Integer> list2=Arrays.asList(4,5,6);
    List<Integer> mergedListUsingFlatMap = Stream.of(list1,list2).flatMap(List::stream).collect(Collectors.toList());
    System.out.println("**IMP mergedListUsingFlatMap : "+mergedListUsingFlatMap);

        int firstElementFromListGreaterThan1 = list1.stream().filter(x -> x > 1).findFirst().get();
        System.out.println("**IMP firstElementFromListGreaterThan1 : "+firstElementFromListGreaterThan1);

        Integer lowestNumberFromList = numbers.stream().min(Integer::min).get();
        System.out.println("**IMP lowestNumberFromList : "+lowestNumberFromList);

        Set<Integer> duplicatesfromList = numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).collect(Collectors.toSet());
        System.out.println("**IMP duplicatesfromList : "+duplicatesfromList);


    }
}
