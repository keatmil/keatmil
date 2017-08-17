package controller.returntype;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	@RequestMapping("/ReturnType/ModelAndView.do")
	public ModelAndView modelandview(@RequestParam Map map, Model model) throws Exception {
		model.addAttribute("message", String.format("[파라미터: %s]", map.get("returntype")));
		model.addAllAttributes(map);
		return new ModelAndView("forward:/ReturnType_05/ReturnType.jsp");
	}
	
	@RequestMapping("/ReturnType/String.do")
	public String string(@RequestParam String returntype, Map map) throws Exception {
		map.put("message", String.format("[파라미터: %s]", returntype));
		map.put("returntype", returntype);
		
		return "forward:/ReturnType_05/ReturnType.jsp"; 
	}
	
	@RequestMapping("/ReturnType/Void.do")
	public void noreturn(@RequestParam String returntype, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h2>반환타입 보이드</h2>");
		out.println("<fieldset>");
		out.println("<legend>파라미터: "+returntype+"</legend>");
		out.println("웹브라우저에 직접 출력합니다");
		out.println("</fieldset>");
		
		out.close();
		
	}
}
