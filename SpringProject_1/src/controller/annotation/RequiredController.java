package controller.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequiredController {
	private String message;

	@Required
	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping("/Annotation/Required.do")
	public String execute(Map map) throws Exception {

		map.put("message", message);
		return "/Annotation_07/Annotation.jsp";
	}
}
