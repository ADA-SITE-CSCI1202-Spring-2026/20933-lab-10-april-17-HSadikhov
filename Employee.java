import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }

    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ali", "Aliyev", 55000.0));
        employees.add(new Employee("Gunay", "Sarifova", 75000.0));
        employees.add(new Employee("Leyla", "Quliyev", 62000.0));

        
        Function<Employee, String> formatCard = e -> 
            "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();

        
        Function<Employee, Double> salaryPicker = Employee::getSalary;

        
        System.out.println("--- Employee ID Cards ---");
        for (Employee emp : employees) {
            
            String card = formatCard.apply(emp);
            
            
            Double rawSalary = salaryPicker.apply(emp);
            
            System.out.println(card);
            
        }
    }
}