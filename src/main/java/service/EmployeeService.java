package service;

import domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<String, Employee> employees;
    public EmployeeService() {
        employees = new HashMap<>();
    }
    public void addEmployee(Employee employee) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employees.put(fullName, employee);
    }
    public void removeEmployee(String firstName, String lastName){
        String fullName = firstName + " " + lastName;
        employees.remove(fullName);
    }
    public Employee findEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return employees.get(fullName);
    }

    public List<Employee> getAllEmployees(){
        return new ArrayList<>(employees.values());
    }
    public void addTestData(){
        employees.put("Захаров", new Employee("Сергей", "Захаров", 40345, "2"));
        employees.put("Совков", new Employee("Антон", "Совков", 24345, "1"));
        employees.put("Шевков", new Employee("Юрий", "Шевков", 35785, "3"));
    }
}
