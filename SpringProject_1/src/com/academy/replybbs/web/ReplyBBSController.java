package com.academy.replybbs.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.impl.PagingUtil;
import com.academy.replybbs.service.impl.ReplyBBSServiceImpl;

@SessionAttributes("id")
@Controller
public class ReplyBBSController {
	@Value("${PAGE_SIZE}")
	private int pageSize;
	
	@Value("${BLOCK_PAGE}")
	private int blockPage;
	
	@Resource(name="bbsService")
	private ReplyBBSServiceImpl service;

	@RequestMapping("/ReplyBBS/BBS/List.bbs")
	public String list(HttpServletRequest req, @RequestParam Map map,
			@RequestParam(required = false, defaultValue = "1") int nowPage, Model model) throws Exception {
		
		//페이징을 위한 로직 시작]
		// 전체 레코드 수
		int totalRecordCount = service.getTotalCount(map);
		// 페이지 사이즈
		// 블락페이지
		// 전체 페이지수]
		int totalPage = (int) Math.ceil((double) totalRecordCount / pageSize);
		// 현재 페이지를 파라미터로 받기]
		// 시작 및 끝 ROWNUM구하기]
		int start = (nowPage - 1) * pageSize + 1;
		int end = nowPage * pageSize;

		map.put("start", start);
		map.put("end", end);
		// 페이징을 위한 로직 끝]
		List<ReplyBBSDto> list = service.selectList(map);
		
		String pagingString = PagingUtil.pagingText(totalRecordCount, pageSize, blockPage, nowPage, req.getContextPath()+"/ReplyBBS/BBS/List.bbs?");
		model.addAttribute("list", list);
		model.addAttribute("pagingString", pagingString);
		return "view/List.tiles";
	}
	
	@RequestMapping("/ReplyBBS/BBS/Write.bbs")
	public String write(@RequestParam Map map, @ModelAttribute("id") String id) throws	Exception {
		if(map.get("mode") == null)	return "view/Write.tiles";
		
		ReplyBBSDto dto = new ReplyBBSDto();
		dto.setContent(map.get("content").toString());
		dto.setTitle(map.get("title").toString());
		dto.setId(id);
		service.insert(dto);
		return "forward:/ReplyBBS/BBS/List.bbs";
	}
	
	@RequestMapping("/ReplyBBS/BBS/View.bbs")
	public String view(ModelMap model, @RequestParam Map map) throws Exception {
		ReplyBBSDto dto = service.selectOne(map);
		dto.setContent(dto.getContent().replace("\r\n", "<br />"));
		model.addAttribute("dto", dto);
		return "view/View.tiles";
	}
	
	@RequestMapping("/ReplyBBS/BBS/Reply.bbs")
	public String reply(HttpServletRequest req, @RequestParam Map map, HttpSession session) throws Exception {
		if(req.getMethod().toUpperCase().equals("GET")){
			ReplyBBSDto dto = service.selectOne(map);
			req.setAttribute("dto", dto);
			return "view/Reply.tiles";
		}
		map.put("id", session.getAttribute("id"));
		service.reply(map);
		return "forward:/ReplyBBS/BBS/List.bbs";
	}
	
	@RequestMapping("/ReplyBBS/BBS/Edit.bbs")
	public String edit(HttpServletRequest req, @RequestParam Map map) throws Exception {
		ReplyBBSDto dto = service.selectOne(map);
		if(req.getMethod().toUpperCase().equals("GET")){
			req.setAttribute("dto", dto);
			return "view/Edit.tiles";
		}
		dto.setContent(map.get("content").toString());
		dto.setTitle(map.get("title").toString());
		
		int count = service.update(dto);	
		req.setAttribute("no", dto.getNo());
		req.setAttribute("SUC_FAIL", count);
		req.setAttribute("WHERE", "EDT");
		return "view/Message";
	}
	
	@RequestMapping("/ReplyBBS/BBS/Delete.bbs")
	public String delete(ReplyBBSDto dto, Model model) throws Exception {
		
		int count = service.delete(dto);

		model.addAttribute("no", dto.getNo());
		model.addAttribute("SUC_FAIL", count);
		return "view/Message";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
