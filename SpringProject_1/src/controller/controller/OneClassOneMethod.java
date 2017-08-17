package controller.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OneClassOneMethod {
	@RequestMapping ({
		"/Controller/OneMethod/List.do", 
		"/Controller/OneMethod/Edit.do",
		"/Controller/OneMethod/Delete.do",
		"/Controller/OneMethod/View.do"
		})
	public String parameter(@RequestParam int paramvar, Map map) throws Exception {
		switch (paramvar) {
		case 1:
			map.put("message", "목록요청입니다");
			break;
		case 2:
			map.put("message", "수정요청입니다");
			break;
		case 3:
			map.put("message", "삭제요청입니다");
			break;
		default:
			map.put("message", "뷰요청입니다");
			break;
		}
		return "/Controller_02/Controller.jsp";
	}
	
	@RequestMapping ("/Controller/OneMethod/{path}")
	public String noparam(@PathVariable String path, Map map) throws Exception {
		switch (path) {
		case "List":
			map.put("message", "목록요청입니다");
			break;
		case "Edit":
			map.put("message", "수정요청입니다");
			break;
		case "Delete":
			map.put("message", "삭제요청입니다");
			break;
		default:
			map.put("message", "뷰요청입니다");
			break;
		}
		return "/Controller_02/Controller.jsp";
	}
}
