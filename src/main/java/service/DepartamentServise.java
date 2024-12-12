package service;

import domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartamentServise {
    private EmployeeService employeeService;

    public DepartamentServise(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public Employee getEmployeeWithMinSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public Map<String, List<Employee>> getAllEmployeesByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
