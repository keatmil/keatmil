package controller.injection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {
	private Person per1, per2;

	public void setPer1(Person per1) {
		this.per1 = per1;
	}

	public void setPer2(Person per2) {
		this.per2 = per2;
	}
	
	@RequestMapping("/Injection/Setter.do")
	public String execute(Model model) throws Exception {
		model.addAttribute("personInfo", per1.toString()+per2);
		return "forward:/Injection_06/Injection.jsp";
	}
}
