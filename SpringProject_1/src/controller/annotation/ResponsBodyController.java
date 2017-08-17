package controller.annotation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponsBodyController {
	/*
	@RequestMapping("/Annotation/ResponseBody.do")
	public void execute(HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h2>반환타입: void, 매개변수: 서블릿 API(HttpServletResponse)사용</h2>");
		out.close();
	}*/
	@RequestMapping(value="/Annotation/ResponseBody.do",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String execute() throws Exception {
		return "<h2>반환타입: String, 매개변수: 서블릿 API 미사용, @ResponseBody 사용</h2>";
	}
	
}
