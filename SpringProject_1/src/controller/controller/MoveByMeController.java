package controller.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoveByMeController {
	@RequestMapping("/Controller/MoveByMe.do")
	
	public String execute(Map map) throws Exception {
		map.put("message", "[MoveByMe]");
		return "/Controller_02/Controller.jsp";
	}
}
