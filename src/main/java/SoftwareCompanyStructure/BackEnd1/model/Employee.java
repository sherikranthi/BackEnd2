package SoftwareCompanyStructure.BackEnd1.model;

import jakarta.persistence.*;





@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long managerId;

    private String employeeType;



    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Team team;

    // Constructors

    public Employee() {
        // Default constructor for JPA
    }

    public Employee(String firstName, String lastName, Long managerId, Role role, Team team,String employeeType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerId = managerId;
        this.role = role;
        this.team = team;
        this.employeeType = employeeType;
    }

    // Getters and Setters


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // Other methods as needed
}
