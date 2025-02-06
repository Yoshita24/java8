/*concept is to copy an existing object rather than creating new instance from scratch.
because creating new instance is costly
avoid creating new instances from scratch
faster than constructing object manually
easily create multiple versions of object
Prototype design pattern is creational pattern that allows cloning object without depending
on their exact class. It is useful when object creation is expensive
Imagine a corporate office where employees need an ID Card.
Each new employee needs a similar ID card but with different details.
Instead of creating each ID card from scratch, we clone a pre-designed template and modify only specific fields.

Advantage	Benefit
Reduces Object Creation Overhead	No need to create a new ID card object from scratch.
Better Performance	Cloning is faster than creating new instances.
Scalability	Easily create thousands of employee ID cards efficiently.

Why Use Prototype Pattern in Spring Boot?
✔ Reduces Object Creation Overhead → No need to create an ID card from scratch every time.
✔ Encapsulates Object Creation Logic → Centralized cloning process.
✔ Improves Performance → Cloning is faster than constructing new objects.
*/
 interface Prototype
{
    Prototype clone();
}
//This will implement the cloning method.
class EmployeeIDCard implements Prototype
{
    private String employeeName;
    private String companyName;
    private String department;
    private int idNumber;

    public EmployeeIDCard(String employeeName, String companyName, String department, int idNumber) {
        this.employeeName = employeeName;
        this.companyName = companyName;
        this.department = department;
        this.idNumber = idNumber;
    }

    @Override
    public Prototype clone() {
        return new EmployeeIDCard(employeeName,companyName, department, idNumber);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "EmployeeIDCard{" +
                "employeeName='" + employeeName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", department='" + department + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }

    public void showDetails() {
        System.out.println("EmployeeName : "+employeeName+" companyName : "+companyName+" department : "+department+" idNumber : "+idNumber);
    }
}
public class PrototypeeDesignPattern {
    public static void main(String[] args) {
        // Original ID Card Template
        EmployeeIDCard originalCard = new EmployeeIDCard("TechCorp", "John Doe", "IT", 1001);
        originalCard.showDetails();

        // Cloning ID Card for a New Employee
        EmployeeIDCard clonedCard = (EmployeeIDCard) originalCard.clone();
        clonedCard.setEmployeeName("Alice Smith");
        clonedCard.setIdNumber(1002);
        clonedCard.showDetails();

        // Another Clone
        EmployeeIDCard clonedCard2 = (EmployeeIDCard) originalCard.clone();
        clonedCard2.setEmployeeName("Bob Williams");
        clonedCard2.setIdNumber(1003);
        clonedCard2.showDetails();

    }
}
