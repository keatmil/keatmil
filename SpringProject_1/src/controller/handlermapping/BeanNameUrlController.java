package controller.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BeanNameUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "[BeanNameUrlHandlerMapping]");
		mav.setViewName("/HandlerMapping_01/HandlerMapping.jsp");
		return mav;
	}
	
}
