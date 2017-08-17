package controller.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {
	@Resource(name="command_first")
	private Command first;

	@Resource(name="command_second")
	private Command second;
	
	@RequestMapping("/Annotation/Resource.do")
	public String execute(ModelMap model) throws Exception {
		model.addAttribute("message", String.format("[첫번째 객체: %s] [두번째 객체: %s]", first.getName(), second.getName()));
		return "/Annotation_07/Annotation.jsp";
	}
}
