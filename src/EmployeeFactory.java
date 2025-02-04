//focus on creating object for interface rather than implementation
//Losse coupling , more robust code
public class EmployeeFactory {
    public static Employeee getEmployee(String empType)
    {
        if(empType.trim().equalsIgnoreCase("ANDROID DEVELOPER"))
            return new AndroidDeveloper();
        else if(empType.trim().equalsIgnoreCase("WEB DEVELOPER"))
            return new WebDeveloper();
        else
            return null;
    }
}
class AndroidDeveloper implements Employeee
{
    public void salary() {
        System.out.println("Salary is 4000");
    }
}
class WebDeveloper implements Employeee
{

    @Override
    public void salary() {
        System.out.println("Salary is 7000");

    }
}
interface Employeee{
   abstract public void salary() ;

}

 class EmployeeFactoryDemo
{
    public static void main(String[] args) {
        Employeee androidDeveloper = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
        androidDeveloper.salary();
        Employeee webDeveloper = EmployeeFactory.getEmployee("WEB DEVELOPER");
        webDeveloper.salary();
    }
}