package controller.basic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationByController {
	@RequestMapping("/Basic/Annotation.do")
	
	public String execute(HttpServletRequest req) throws Exception {
		String message = req.getParameter("message");
		req.setAttribute("message", message);
		return "/index.jsp";
	}
	
}
