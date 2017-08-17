package controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ControllerByController implements Controller {
	public ControllerByController() {
		System.out.println("[생성자]");
	}

	public void init() {
		System.out.println("[초기화 매소드: init()]");
	}

	public void destroy() {
		System.out.println("[소멸 매소드: destroy]");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("[컨트롤러메소드: handleRequest()]");
		String message = req.getParameter("message");
		// req.setAttribute("message", message);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index.jsp");
		mav.addObject("message", message);
		return mav;
	}

}
