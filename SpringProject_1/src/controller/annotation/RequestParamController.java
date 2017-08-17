package controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	@RequestMapping("/Annotation/RequestParamEqual.do")
	public String equal(@RequestParam String name, @RequestParam int years, HttpServletRequest req, Model model)
			throws Exception {
		/*
		 * String name = req.getParameter("name"); int years =
		 * Integer.parseInt(req.getParameter("years"));
		 */
		model.addAttribute("name", name);
		model.addAttribute("years", years + 10);

		return "/Annotation_07/Annotation.jsp";
	}

	@RequestMapping("/Annotation/RequestParamDiff.do")
	public String diff(@RequestParam(name = "nick2", required = true, defaultValue = "디폴트값") String name,
			@RequestParam("age") int years, Model model) throws Exception {
		/*
		 * String name = req.getParameter("name"); int years =
		 * Integer.parseInt(req.getParameter("years"));
		 */
		model.addAttribute("name", name);
		model.addAttribute("years", years + 10);

		return "/Annotation_07/Annotation.jsp";
	}

	@RequestMapping("/Annotation/RequestParamMap.do")
	public String map(@RequestParam Map map, ModelMap model, HttpServletRequest req) throws Exception {
		StringBuffer buffer = new StringBuffer();
		for (String inter : req.getParameterValues("inters")) {
			buffer.append(inter);
		}
		model.addAllAttributes(map);
		model.addAttribute("inters", buffer);

		return "/Annotation_07/Annotation.jsp";
	}

}
