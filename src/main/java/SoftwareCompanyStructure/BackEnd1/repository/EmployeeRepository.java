package SoftwareCompanyStructure.BackEnd1.repository;


import SoftwareCompanyStructure.BackEnd1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {



    Employee findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByManagerId(Long managerId);
}

