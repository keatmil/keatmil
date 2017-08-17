package controller.resouce;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import resource.UserCommand;

@Controller
public class ResourceController {
	
	@Value("${name}")
	private String name;
	@Value("${pass}")
	private String pass;
	@Value("${user}")
	private String user;
	
	@Resource(name="command")
	private UserCommand command;
	@RequestMapping("/Resource/Resource.do")
	public String execute(Model model) throws Exception {
		model.addAttribute("resource", command);
		model.addAttribute("value", String.format("@value어노테이션: 아뒤: %s, 이름: %s, 비번: %s", user, name, pass));
		return "/Resource_08/Resource.jsp";
		
	}
}
