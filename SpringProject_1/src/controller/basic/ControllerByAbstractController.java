package controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ControllerByAbstractController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String message = req.getParameter("message");
		
		ModelAndView mav = new ModelAndView("/index.jsp", "message", message);
		return mav;
	}

}
