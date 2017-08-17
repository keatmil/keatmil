package controller.nodelandview;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ModelAndViewController {
	@RequestMapping("/ModelAndView/NoParam.do")
	public ModelAndView noparam() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("UserID", "kosmo");
		mav.addObject("UserPWD", "1234");
		/*mav.setViewName("/ModelAndView_03/ModelAndView.jsp");*/
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/ModelAndView_03/ModelAndView.jsp");
		mav.setView(view);
		return mav;
		
	}//noparam

	@RequestMapping("/ModelAndView/YesParam.do")
	public ModelAndView yesparam(Model model,Map map, ModelMap modelmap) throws Exception {
		ModelAndView mav = new ModelAndView();
		/*map.put("UserID", "spring");
		map.put("UserPWD", "5678");*/
		
		/*model.addAttribute("UserID", "spring");
		model.addAttribute("UserPWD", "5678");*/
		

		modelmap.addAttribute("UserID", "spring");
		modelmap.addAttribute("UserPWD", "5678");
		mav.setViewName("/ModelAndView_03/ModelAndView.jsp");		
		return mav;
	}//yesparam
	
	@RequestMapping("/ModelAndView/Forward.do")
	public ModelAndView forward(@RequestParam Map map, Map dismap, Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		/*dismap.put("UserID", "SPRING");
		dismap.put("UserPWD", "9999");*/
		
		/*model.addAttribute("UserID", "SPRING");
		model.addAttribute("UserPWD", "9999");*/
		
		/*model.addAllAttributes(map);
		mav.setViewName("/ModelAndView_03/ModelAndView.jsp");		
		return mav;*/
		
		return new ModelAndView("forward:/ModelAndView/NoParam.do");
	}//forward
	
	@RequestMapping("/ModelAndView/Redirect.do")
	public ModelAndView redirect(@RequestParam Map map, ModelMap modelmap){
		
		map.put("UserID", "UID");
		map.put("UserPWD", "UPWD");
		modelmap.addAllAttributes(map);
		
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/ModelAndView_03/ModelAndView.jsp");
		return mav;*/
		/*return new ModelAndView("redirect:/ModelAndView_03/ModelAndView.jsp");*/
		/*return new ModelAndView("redirect:/ModelAndView/NoParam.do");*/
		RedirectView view = new RedirectView("/ModelAndView_03/ModelAndView.jsp", true);
		return new ModelAndView(view);
	}//redirect
}//class
