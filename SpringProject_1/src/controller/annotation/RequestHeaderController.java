package controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {
	/*
	@RequestMapping("/Annotation/RequestHeader.do")
	public String execute(HttpServletRequest req) throws Exception {
		String browser = req.getHeader("user-agent");
		req.setAttribute("browser", browser);
		return "/Annotation_07/Annotation.jsp";
	}
	*/
	@RequestMapping("/Annotation/RequestHeader.do")
	public String execute(@RequestHeader(value="user-agent", 
										required=false, 
										defaultValue="헤더명 미존재시 대체") String browser, 
						Model model) throws Exception {
		model.addAttribute("browser", browser);
		return "/Annotation_07/Annotation.jsp";
	}
}
