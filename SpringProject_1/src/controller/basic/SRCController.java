package controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SRCController {

	@RequestMapping("/Basic/SRC.daum")
	
	public String execute(@RequestParam String message, Model model) throws Exception {
		model.addAttribute("message", message);
		return "/index.jsp";
	}
}
