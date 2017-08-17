package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OneClassMultiMethod {
	@RequestMapping("/Controller/OneClass/List.do")
	public String list(Model model) throws Exception {
		model.addAttribute("message", "목록요청입니다");
		return "/Controller_02/Controller.jsp";
	}
	
	@RequestMapping("/Controller/OneClass/Edit.do")
	public String edit(Model model) throws Exception {
		model.addAttribute("message", "수정요청입니다");
		return "/Controller_02/Controller.jsp";
	}
	
	@RequestMapping("/Controller/OneClass/Delete.do")
	public String delete(Model model) throws Exception {
		model.addAttribute("message", "삭제요청입니다");
		return "/Controller_02/Controller.jsp";
	}
	
	@RequestMapping("/Controller/OneClass/View.do")
	public String view(Model model) throws Exception {
		model.addAttribute("message", "뷰요청입니다");
		return "/Controller_02/Controller.jsp";
	}
}
