package controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController {
	/*
	@RequestMapping("/Exception/Exception.do")
	public String exception(@RequestParam String years, Model model) throws Exception {
		try {
			model.addAttribute("message", String.format("당신의 10년후 나이는 %d살 입니다", Integer.parseInt(years)+10));
		} catch (Exception e) {
			model.addAttribute("message", "나이는 숫자만 입력하세요");
		}
		return "/Exception_13/Exception.jsp";
	}
	*/
	
	@RequestMapping("/Exception/Exception.do")
	public String exception(@RequestParam String years, Model model, HttpServletRequest req) throws Exception {
		req.setAttribute("message", "나이는 숫자만 입력");
		model.addAttribute("message", "나이는 숫자만 입력..................");
		model.addAttribute("message", String.format("당신의 10년후 나이는 %d살 입니다", Integer.parseInt(years)+10));
		return "/Exception_13/Exception.jsp";
	}
	
}
