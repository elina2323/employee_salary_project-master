package kg.megacom.employee_salary_project.services;

import kg.megacom.employee_salary_project.models.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    EmployeeDto getEmployee(Long employeeId);

    Map<String, Boolean> remove(Long employeeId);
}

