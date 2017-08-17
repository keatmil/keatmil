package controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingController {
	/*
	 * @RequestMapping("/Annotation/RequestMappingBoth.do") public String
	 * both(HttpServletRequest req, Model model) throws Exception {
	 * model.addAttribute("UserID", req.getParameter("UserID"));
	 * model.addAttribute("UserPWD", req.getParameter("UserPWD")); return
	 * "/Annotation_07/Annotation.jsp"; }
	 * 
	 * @RequestMapping(value="/Annotation/RequestMappingOne.do",
	 * method=RequestMethod.POST) public String one(HttpServletRequest req)
	 * throws Exception { req.setAttribute("UserID",
	 * req.getParameter("UserID")); req.setAttribute("UserPWD",
	 * req.getParameter("UserPWD")); return "/Annotation_07/Annotation.jsp"; }
	 * 
	 * @RequestMapping({"/Annotation/RequestMappingBoth.do",
	 * "/Annotation/RequestMappingOne.do"}) public String multi(@RequestParam
	 * Map map, Model model) throws Exception { model.addAllAttributes(map);
	 * return "/Annotation_07/Annotation.jsp"; }
	 */

	@RequestMapping("/Annotation/{path}")
	public String path(@PathVariable String path, @RequestParam Map map, Model model) throws Exception {
		model.addAllAttributes(map);
		model.addAttribute("message", path);
		return "/Annotation_07/Annotation.jsp";
	}

}
