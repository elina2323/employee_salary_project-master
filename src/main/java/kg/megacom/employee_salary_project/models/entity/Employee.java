package kg.megacom.employee_salary_project.models.entity;
import kg.megacom.employee_salary_project.models.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Status status;

}
