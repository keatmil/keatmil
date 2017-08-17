package controller.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutowiredController {
	@Autowired(required=false)
	private Command command_first;
	
	@Autowired(required=false)
	private Command command_second;
	
	@RequestMapping("/Annotation/Autowired.do")
	public String execute(Model model) throws Exception {
		model.addAttribute("message", String.format("[command_first: %s] [command_second: %s]", command_first, command_second));
		return "/Annotation_07/Annotation.jsp";
	}
	
}
