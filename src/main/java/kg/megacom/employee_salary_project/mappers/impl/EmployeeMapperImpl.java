package kg.megacom.employee_salary_project.mappers.impl;
import kg.megacom.employee_salary_project.mappers.EmployeeMapper;
import kg.megacom.employee_salary_project.models.dto.EmployeeDto;
import kg.megacom.employee_salary_project.models.entity.Employee;
import kg.megacom.employee_salary_project.models.enums.Status;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        if (employeeDto.getId() != null){
            employee.setId(employeeDto.getId());
        }
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setStatus(Status.ACTIVE);
        return employee;
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee, double salary) {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setStatus(Status.ACTIVE);
        employeeDto.setSalary(salary);
        return employeeDto;
    }
}

