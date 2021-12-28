package kg.megacom.employee_salary_project.models.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue
    private Long id;
    private double salary;

    @CreationTimestamp
    @Column(name = "CreatedDate", updatable=false)
    LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "ModifiedDate")
    LocalDateTime lastModified;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
