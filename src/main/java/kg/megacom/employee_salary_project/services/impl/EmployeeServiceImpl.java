package kg.megacom.employee_salary_project.services.impl;
import kg.megacom.employee_salary_project.dao.EmployeeRepo;
import kg.megacom.employee_salary_project.exceptions.ResourceNotFoundException;
import kg.megacom.employee_salary_project.mappers.EmployeeMapper;
import kg.megacom.employee_salary_project.models.dto.EmployeeDto;
import kg.megacom.employee_salary_project.models.entity.Employee;
import kg.megacom.employee_salary_project.models.enums.Status;
import kg.megacom.employee_salary_project.services.EmployeeService;
import kg.megacom.employee_salary_project.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    private final EmployeeRepo employeeRepository;

    private final SalaryService salaryService;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepo employeeRepository,
                               SalaryService salaryService) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        salaryService.CreateEmployeeSalary(employeeDto.getSalary(), employee);
        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());

    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No employee record exist for given id : "));
        employee = employeeRepository.save(employee);

        salaryService.CreateEmployeeSalary(employeeDto.getSalary(), employee);
        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());
    }

    @Override
    public List<EmployeeDto> findAll() {

        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList
                .stream()
                .map(x-> employeeMapper.toEmployeeDto(x, salaryService.findCurrentSalary(x)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No employee record exist for given id : "
                        + employeeId));
        return employeeMapper.toEmployeeDto(employee, employeeId);
    }

    @Override
    public Map<String, Boolean> remove(Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No employee record exist for given id : "
                        + employeeId));
        employee.setStatus(Status.INACTIVE);
        employeeRepository.save(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("nonactive ", Boolean.TRUE);
        return response;
    }

}
