package controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnotherDispatcherController {
	
	@RequestMapping("/Basic/AnotherDispatcher.kosmo")
	
	public ModelAndView execute(@RequestParam String message) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", message);
		mav.setViewName("/index.jsp");
		return mav;
	}
}
