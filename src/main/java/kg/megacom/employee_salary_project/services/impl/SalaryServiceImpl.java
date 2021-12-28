package kg.megacom.employee_salary_project.services.impl;
import kg.megacom.employee_salary_project.dao.SalaryRepo;
import kg.megacom.employee_salary_project.models.entity.Employee;
import kg.megacom.employee_salary_project.models.entity.Salary;
import kg.megacom.employee_salary_project.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepo salaryRepo;

    @Autowired
    public SalaryServiceImpl(SalaryRepo salaryRepo) {
        this.salaryRepo = salaryRepo;
    }

    private void createNewSalary(double salary, Employee employee) {
        Salary newSalary = new Salary();
        newSalary.setSalary(salary);
        newSalary.setEmployee(employee);
        newSalary.setDateCreated(LocalDateTime.now());
        newSalary.setLastModified(LocalDateTime.of(2999, 12, 31, 0, 0,0));
        salaryRepo.save(newSalary);
    }

    @Override
    public double findCurrentSalary(Employee employee) {
        Salary salary = salaryRepo.findByEmployeeCurrentSalary(employee.getId(), LocalDateTime.now());
        return salary.getSalary();
    }

    @Override
    public void CreateEmployeeSalary(double salary, Employee employee) {
        Salary currentSalary = salaryRepo.findByEmployeeCurrentSalary(employee.getId(), LocalDateTime.now());
        if (currentSalary == null){
            createNewSalary(salary, employee);
        }else {
            if (salary != currentSalary.getSalary()){
                LocalDateTime localDateTime = LocalDateTime.now().minusSeconds(1);
                currentSalary.setLastModified(localDateTime);
                salaryRepo.save(currentSalary);
                createNewSalary(salary, employee);
            }
        }

    }
}
