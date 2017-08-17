package com.academy.replybbs.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.academy.replybbs.service.impl.ReplyBBSServiceImpl;

@SessionAttributes("id")
@Controller
public class LoginController {
	
	@Resource(name="bbsService")
	private ReplyBBSServiceImpl bbsService;
	
	@RequestMapping("/ReplyBBS/Login/Login.bbs")
	public String login() throws Exception {
		return "login/Login.tiles";
	}
	
	@RequestMapping("/ReplyBBS/Login/LoginProcess.bbs")
	public String process(@RequestParam Map map, Model model) throws Exception {
		boolean isLogin = bbsService.login(map);
		if (isLogin) {
			model.addAllAttributes(map);
		} else {
			model.addAttribute("loginError","아이디 또는 비밀번호가 일치하지 않습니다.");
			return "forward:/ReplyBBS/Login/Login.bbs";
		}
		return "forward:/ReplyBBS/Login/Login.bbs";
	}
	
	@RequestMapping("/ReplyBBS/Login/Logout.bbs")
	public String logout(SessionStatus status) throws Exception {
		status.setComplete();
		return "forward:/ReplyBBS/Login/Login.bbs";
	}
}
