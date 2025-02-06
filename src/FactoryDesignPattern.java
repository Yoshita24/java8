public class FactoryDesignPattern {
   /* When there is superclass and multiple subclasses and we want to get object of subclasses
    based on input and requirement
    Then we can create factory class which takes responsibility of creating object of class based on input
    Adv - focus on creating object for interface rather than implementation
    Loose coupling,more robust code

    Depending on requirement u ll create class
    We want to hide logic of object creation from user
    */
}
//parent type employeee .. so child would be type of that
interface Employeeee
{
    int salary();
}
class AndroidDeveloperr implements Employeeee
{

    @Override
    public int salary() {
        System.out.println("Getting Android Developer salary");
        return 1000;
    }
}
class WebDeveloperr implements Employeeee
{

    @Override
    public int salary() {
        System.out.println("Getting Web Developer salary");
        return 5000;
    }
}
//foucs on type creating object for interface type
class EmployeeeeFactory
{
    public static Employeeee getEmployee(String empType) //here input is empType
    {
        if(empType.trim().equalsIgnoreCase("Android Developer"))
        {
            return new AndroidDeveloperr();
        }
        else if(empType.trim().equalsIgnoreCase("Web Developer"))
        {
            return new WebDeveloperr();
        }
        else {
            return null;
        }
    }
}
class DeveloperClient
{
    public static void main(String[] args) {
        //Employeeee employeeee = new AndroidDeveloperr(); --tightly coupled
        //here we jst need to pass the type of employee which u want n not to see how it would get created
        Employeeee employee=EmployeeeeFactory.getEmployee("Android Developer");
        System.out.println("salary : "+employee.salary());
        Employeeee employee1=EmployeeeeFactory.getEmployee("Web Developer");
        System.out.println("salary : "+employee1.salary());
    }
}