package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerByAnnotation {
	@RequestMapping("/Controller/Annotation.do")
	public String execute(Model model) throws Exception {
		model.addAttribute("message", "어노테이션");
		return "/Controller_02/Controller.jsp";
	}
}
