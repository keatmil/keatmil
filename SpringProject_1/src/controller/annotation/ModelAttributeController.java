package controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeController {
	@RequestMapping("/Annotation/ModelAttribute.do")
	/*
	 * public String map(@RequestParam Map map, Model model, HttpServletRequest
	 * req) throws Exception {
	 * 
	 * 
	 * StringBuffer buffer = new StringBuffer(); for(String inter :
	 * req.getParameterValues("inters")){ buffer.append(inter+"&nbsp"); }
	 * map.put("inters", buffer); map.put("self",
	 * map.get("self").toString().replace("\r\n", "<br />"));
	 * model.addAllAttributes(map);
	 * 
	 * 
	 * return "/Annotation_07/ModelAttribute.jsp"; }
	 */

	public String command(Command command, Map map) throws Exception {
		command.setSelf(command.getSelf().replace("\r\n", "<br />"));
		map.put("cmd", command);

		return "/Annotation_07/ModelAttribute.jsp";
	}

}
