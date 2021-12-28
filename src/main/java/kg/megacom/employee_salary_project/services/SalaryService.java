package kg.megacom.employee_salary_project.services;

import kg.megacom.employee_salary_project.models.entity.Employee;

public interface SalaryService {

    double findCurrentSalary(Employee employee);

    void CreateEmployeeSalary(double salary, Employee employee);
}
