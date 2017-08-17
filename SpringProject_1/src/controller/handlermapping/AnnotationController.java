package controller.handlermapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {

	@RequestMapping("/HandlerMapping/Annotation.do")
	
	public ModelAndView handleRequest() throws Exception {
		
		return new ModelAndView("/HandlerMapping_01/HandlerMapping.jsp", "message", "[DefaultAnnotationHandlerMapping]");
	}
}
