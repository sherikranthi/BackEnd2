package SoftwareCompanyStructure.BackEnd1.controller;
import SoftwareCompanyStructure.BackEnd1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import SoftwareCompanyStructure.BackEnd1.model.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @GetMapping("/details")
    public List<Employee> getEmployeeDetailsByName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return employeeService.getEmployeeDetailsByName(firstName, lastName);
    }

    @GetMapping("/agile-standup-reminders")
    public List<String> getAgileStandUpReminders() {
        List<Employee> technicalEmployees = employeeService.getTechnicalEmployees();
        List<String> reminders = new ArrayList<>();

        for (Employee employee : technicalEmployees) {
            reminders.add("Get Ready for the Standup: " + employee.getFirstName() + " " + employee.getLastName());
        }

        return reminders;
    }


}
