package controller;

import domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartamentServise;
import service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private DepartamentServise departamentServise;

    private EmployeeService employeeService;

    public DepartmentController(DepartamentServise departamentServise, EmployeeService employeeService) {
        this.departamentServise = departamentServise;
        this.employeeService = employeeService;
    }
    @GetMapping(value = "/add-data")
    public void addTestData(){
        employeeService.addTestData();
    }

    @GetMapping(value = "/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") String departmentId){
        return departamentServise.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }
    @GetMapping(value = "/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") String departmentId){
        return departamentServise.getEmployeeWithMinSalaryByDepartment(departmentId);
    }
    @GetMapping(value = "/all")
    public Map<String, List<Employee>> getAllEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) String departmentId){
        if (departmentId == null){
            return departamentServise.getAllEmployeesByDepartments();
        }
        return departamentServise.getAllEmployeesByDepartment(departmentId);
    }
}
