package controller.ajax;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.impl.ReplyBBSDao;

@Controller
public class AjaxController {
	
	@Resource(name="dao")
	private ReplyBBSDao dao;
	
	/*@RequestMapping("/Ajax/NoAjax.do")
	public void noajax(@RequestParam Map map, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		boolean flag = dao.login(map);
		dao.close();
		
		if (flag){
			out.println("<h2>"+map.get("id")+"님 즐감하세요</h2>");
		} else {
			out.println("<script>");
			out.println("alert('아뒤/비번 불일치');");
			out.println("history.back();");
			out.println("</script>");
		}
		out.close();
	}*/
	
	@RequestMapping("/Ajax/NoAjax.do")
	public String noajax(@RequestParam Map map, Model model) throws Exception{
		boolean flag = dao.login(map);
		dao.close();
		
		if (flag){
			model.addAttribute("member", "회원님 반갑습니다");
		} else {
			model.addAttribute("member", "회원이 아닙니다");
		}
		return "/Ajax_12/Ajax.jsp";
	}
	/*
	@RequestMapping("/Ajax/AjaxText.do")
	public void ajaxText(@RequestParam Map map, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		boolean flag = dao.login(map);
		dao.close();
		
		out.println(flag == true ? map.get("id")+"님 즐감" : "가입하고 와");
		out.close();
	}
	*/
	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxText.do", produces="text/html; charset=UTF-8")
	public String ajaxText(@RequestParam Map map) throws Exception{
		boolean flag = dao.login(map);
		dao.close();
		Integer.parseInt("백");
		
		//return flag==true ? "Y" : "N";
		return flag ? "환영합니다" : "다음에 오세요";
	}
	
	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxJson.do", produces="text/html; charset=UTF-8")
	public String ajaxJson(@RequestParam Map map) throws Exception {
		boolean flag = dao.login(map);
		dao.close();
		JSONObject json = new JSONObject();
		json.put("isLogin", flag ? "방가 방가" : "다음에 다시만나요");
		return json.toJSONString();
	}

	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxJsonArray.do", produces="text/html; charset=UTF-8")
	public String ajaxJsonArray() throws Exception {
		Map map = new HashMap();
		map.put("start", 1);
		map.put("end", 10);
		List<ReplyBBSDto> records = dao.selectList(map);
		dao.close();
		List<Map> collections = new Vector<Map>();
		
		for(ReplyBBSDto dto : records){
			Map bbsMap = new HashMap();
			bbsMap.put("title", dto.getTitle());
			bbsMap.put("name", dto.getName());
			bbsMap.put("postdate", dto.getPostdate().toString());
			collections.add(bbsMap);
		}
		System.out.println(JSONArray.toJSONString(collections));
		return JSONArray.toJSONString(collections);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
