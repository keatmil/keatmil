package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConstructorController {
	private Person per1, per2, per3;

	public ConstructorController(Person per1, Person per2, Person per3) {
		this.per1 = per1;
		this.per2 = per2;
		this.per3 = per3;
	}

	public ConstructorController() { }
	
	@RequestMapping("/Injection/Constructor.do")
	public String execute(Map map) throws Exception {
		map.put("personInfo", per1.toString()+per2+per3);
		return "forward:/Injection_06/Injection.jsp";
	}
	
}
