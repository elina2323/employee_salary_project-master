package kg.megacom.employee_salary_project.dao;
import kg.megacom.employee_salary_project.models.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface SalaryRepo extends JpaRepository<Salary, Long> {

    @Query("select u from Salary u where u.employee.id = ?1 and ?2 between u.dateCreated and u.lastModified")
    Salary findByEmployeeCurrentSalary(Long id, LocalDateTime localDateTime);

}
