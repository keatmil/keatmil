package controller.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlSecondController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new ModelAndView("/HandlerMapping_01/HandlerMapping.jsp", "message", "[SimpleUrlSecond.do]");
	}

}
