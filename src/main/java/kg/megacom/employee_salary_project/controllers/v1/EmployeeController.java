package kg.megacom.employee_salary_project.controllers.v1;
import kg.megacom.employee_salary_project.models.dto.EmployeeDto;
import kg.megacom.employee_salary_project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return employeeService.create(employeeDto);

    }

    @PutMapping("/update")
    public EmployeeDto updateEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return employeeService.update(employeeDto);
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/get/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable(value = "employeeId") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }



    @DeleteMapping("/remove/{employeeId}")
    public Map<String, Boolean> removeEmployee(@PathVariable(value = "employeeId") Long employeeId){
        employeeService.remove(employeeId);
        return employeeService.remove(employeeId);
    }


}