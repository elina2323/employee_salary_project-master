package kg.megacom.employee_salary_project.mappers;


import kg.megacom.employee_salary_project.models.dto.EmployeeDto;
import kg.megacom.employee_salary_project.models.entity.Employee;

public interface EmployeeMapper {

    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee, double salary);


}
