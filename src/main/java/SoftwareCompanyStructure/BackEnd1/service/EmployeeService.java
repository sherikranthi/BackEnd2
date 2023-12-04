package SoftwareCompanyStructure.BackEnd1.service;

import SoftwareCompanyStructure.BackEnd1.model.Employee;
import SoftwareCompanyStructure.BackEnd1.model.Role;
import SoftwareCompanyStructure.BackEnd1.model.Team;
import SoftwareCompanyStructure.BackEnd1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeDetailsByName(String firstName, String lastName) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (employee != null) {
            return getEmployeeDetailsByRole(employee.getRole(), employee.getManagerId(), firstName, lastName,employee.getEmployeeType());
        }

        // If no employee found with the given name, return an empty list or handle accordingly
        return List.of();
    }

    public Employee addEmployee(Employee employee) {
        // You can add any additional logic before saving to the database
        return employeeRepository.save(employee);
    }



    private List<Employee> getEmployeeDetailsByRole(Role role, Long managerId, String firstName, String lastName,String EmployeeType) {
        switch (role) {
            case CEO:
                return getAllEmployees();
            case MANAGER:
                return getEmployeesUnderManager(managerId);
            case CTO:
                return getTechnicalEmployees();
            default:
                return List.of(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
        }
    }

    private List<Employee> getEmployeesUnderManager(Long managerId) {
        // Placeholder logic to retrieve employees under the given manager
        return employeeRepository.findByManagerId(managerId);
    }

    private List<Employee> getAllEmployees() {
        // Retrieve all employees
        return employeeRepository.findAll();
    }

    public List<Employee> getTechnicalEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .filter(employee -> isTechnicalTeam(employee.getTeam()))
                .collect(Collectors.toList());
    }

    private boolean isTechnicalTeam(Team team) {
        // Check if the team is one of the technical teams
        return team == Team.Dev_team || team == Team.Testing_team || team == Team.Devops_team;
    }

    @Scheduled(cron = "0 23 11 * * ?")
    public void getAgileStandUpReminders() {
        //List<Employee> technicalEmployees = getTechnicalEmployees();
        // Implement logic to send reminders to technical employees
        for (Employee employee : getAllEmployees()/*technicalEmployees*/) {
            // Replace the following line with your reminder logic
            System.out.println("Get Ready for the Standup @ 11:23: " + employee.getFirstName() + " " + employee.getLastName());
        }
    }


}
