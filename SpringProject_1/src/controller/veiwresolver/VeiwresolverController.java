package controller.veiwresolver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class VeiwresolverController {
	@RequestMapping("/ViewResolver/ViewResolver.vrv")
	public ModelAndView execute(Model model) throws Exception{
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		model.addAttribute("message", simple.format(new Date()));
		
		//return "forward:/ViewResolver_04/ViewResolver.jsp";
		//return "redirect:/ViewResolver_04/ViewResolver.jsp";
		//return new ModelAndView("forward:/ViewResolver_04/ViewResolver.jsp");
		return new ModelAndView(new InternalResourceView("/ViewResolver_04/ViewResolver.jsp"));
		
	}
}
