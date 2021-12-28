package kg.megacom.employee_salary_project.models.dto;

import kg.megacom.employee_salary_project.models.enums.Status;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private double salary;
    private Status status;

}
