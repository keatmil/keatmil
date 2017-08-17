package controller.annotation;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
//@SessionAttributes({ "user", "pass" })
@SessionAttributes(types=LoginCommand.class)
@Controller
public class SessionAttributeController {
	/*
	 * @RequestMapping("/Annotation/SessionAttributeLogin.do") public String
	 * login(HttpSession session, @RequestParam Map map, Model model) throws
	 * Exception { if ("kim".equals(map.get("user")) &&
	 * "1234".equals(map.get("pass"))){ session.setAttribute("user",
	 * map.get("user")); session.setAttribute("pass", map.get("pass"));
	 * } else { model.addAttribute("errorMessage", "회원이 아닙니다"); } return
	 * "/Annotation_07/Annotation.jsp"; }
	 * 
	 * @RequestMapping("/Annotation/SessionAttributeLogout.do") public String
	 * logout(HttpSession session) throws Exception { session.invalidate();
	 * return "/Annotation_07/Annotation.jsp"; }
	 * 
	 * @RequestMapping("/Annotation/isLogin.do") public String
	 * isLogin(HttpSession session, Model model) throws Exception { if
	 * (session.getAttribute("user") != null ){
	 * model.addAttribute("isLoginMessage", "로그인 되었습니다."); } else {
	 * model.addAttribute("isLoginMessage", "로그인 하세요."); } return
	 * "/Annotation_07/Annotation.jsp"; }
	 */

	@RequestMapping("/Annotation/SessionAttributeLogin.do")
	//public String login(@RequestParam Map map, Model model) throws Exception {
	public String login(LoginCommand command, Model model, SessionStatus status) throws Exception {
		/*if ("kim".equals(map.get("user")) && "1234".equals(map.get("pass"))) {
			model.addAllAttributes(map);
		}
		else {
			model.addAttribute("errorMessage", "회원이 아닙니다");
		}
		*/
		System.out.println(command.getUser());
		if (!("kim".equals(command.getUser()) && "1234".equals(command.getPass()))) {
			model.addAttribute("errorMessage", "회원이 아닙니다");
			status.setComplete();
		} 
		return "/Annotation_07/Annotation.jsp";
	}
	
	@RequestMapping("/Annotation/SessionAttributeLogout.do")
	public String logout(SessionStatus session) throws Exception {
		session.setComplete();
		return "/Annotation_07/Annotation.jsp";
	}

	@RequestMapping("/Annotation/isLogin.do")
	/*public String isLogin(@ModelAttribute(value = "user") String id, @ModelAttribute(value = "pass") String pwd,
			Map map) throws Exception {*/
	public String isLogin(@ModelAttribute(value = "loginCommand") LoginCommand command, Map map) throws Exception {
		map.put("isLoginMessage", command.getUser() == null ? "비 로그인상태" : "로그인상태");
		return "/Annotation_07/Annotation.jsp";
	}

}
