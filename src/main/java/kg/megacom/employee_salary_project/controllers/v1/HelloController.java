package kg.megacom.employee_salary_project.controllers.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greeting")
public class HelloController {

    @GetMapping("")
    public String hi(){
        return "Являетесь ли вы клиентом М-Банк";
    }
}
