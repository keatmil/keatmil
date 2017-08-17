package controller.fileupdown;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
	/*@RequestMapping("/FileUpDown/Upload.do")
	public String upload(@RequestParam Map map, @RequestParam MultipartFile upload, HttpServletRequest req) throws Exception{
		String phisicalPath = req.getServletContext().getRealPath("/Upload");
		File file = new File(phisicalPath+File.separator+upload.getOriginalFilename());
		upload.transferTo(file);

		req.setAttribute("writer", map.get("writer"));
		req.setAttribute("title", map.get("title"));
		
		req.setAttribute("originalName", upload.getOriginalFilename());
		req.setAttribute("fileSize", Math.ceil(upload.getSize()/1024.0));
		req.setAttribute("contentType", upload.getContentType());
		return "/FileUpDown_14/UploadComplete.jsp";
	}*/
	
	/*@RequestMapping("/FileUpDown/Upload.do")
	public String upload(MultipartHttpServletRequest msr) throws Exception {
		String phisicalPath = msr.getServletContext().getRealPath("/Upload");
		MultipartFile upload = msr.getFile("upload");
		String realFilename = FileUpDownUtils.getNewFileName(phisicalPath, upload.getOriginalFilename());
		File file = new File(phisicalPath + File.separator + realFilename);
		upload.transferTo(file);

		msr.setAttribute("writer", msr.getParameter("writer"));
		msr.setAttribute("title", msr.getParameter("title"));

		msr.setAttribute("originalName", upload.getOriginalFilename());
		msr.setAttribute("fileSize", Math.ceil(upload.getSize() / 1024.0));
		msr.setAttribute("contentType", upload.getContentType());
		msr.setAttribute("realFilename", realFilename);
		
		return "/FileUpDown_14/UploadComplete.jsp";
	}*/
	
	@RequestMapping("/FileUpDown/Upload.do")
	public String upload(UploadCommand command, Model model, HttpSession session) throws Exception {
		String phisicalPath = session.getServletContext().getRealPath("/Upload");
		String realFilename = FileUpDownUtils.getNewFileName(phisicalPath, command.getUpload().getOriginalFilename());
		File file = new File(phisicalPath + File.separator + realFilename);
		command.getUpload().transferTo(file);

		model.addAttribute("writer", command.getWriter());
		model.addAttribute("title", command.getTitle());
		
		model.addAttribute("originalName", command.getUpload().getOriginalFilename());
		model.addAttribute("fileSize", Math.ceil(command.getUpload().getSize()/1024.0));
		model.addAttribute("contentType", command.getUpload().getContentType());
		
		return "/FileUpDown_14/UploadComplete.jsp";
	}

	@RequestMapping("/FileUpDown/Upload.do")
	public String list(HttpServletRequest req) throws Exception {
		
		return "/FileUpDown_14/List.jsp";
	}
}
