package controller.validation;

import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {
	/*@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand command, Model model) throws Exception {
		if (!validate(command, model)){
			return "/Validation_10/Index.jsp";
		}
		command.setSelf(command.getSelf().replace("\r\n", "<br />"));
		model.addAttribute("command", command);
		return "/Validation_10/Success.jsp";
	}
	
	private boolean validate(FormCommand command, Model model){
		if (command.getName().trim().equals("")){
			model.addAttribute("nameError", "이름을 입력해주세요");
			return false;
		}
		if (command.getYears().trim().equals("")){
			model.addAttribute("yearsError", "나이를 입력해주세요");
			return false;
		} else {
			try {
				Integer.parseInt(command.getYears().trim());
			} catch (Exception e) {
				model.addAttribute("yearsError", "나이는 숫자만 입력해주세요");
			}
		}
		if (command.getGender() == null){
			model.addAttribute("genderError", "성별을 입력해주세요");
			return false;
		} 
		
		model.addAttribute("inters", command.getInters());
		if (command.getInters() == null){
			model.addAttribute("intersError", "관심사항을 선택해주세요");
			return false;
		} else {
			StringTokenizer tokens = new StringTokenizer(command.getInters(), ",");
			if (tokens.countTokens() < 2){
				model.addAttribute("intersError", "관심사항을 2개 이상 선택해주세요");
				return false;
			}
		}
		if (command.getGrade().equals("")){
			model.addAttribute("gradeError", "학력을 선택해주세요");
			return false;
		} else if (command.getSelf().trim().equals("")){
			model.addAttribute("selfError", "자기소개를 입력해주세요");
			return false;
		} 
		return true;
	}*/
	
	@Resource(name="validator")
	private FormValidator validator;
	
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand command, BindingResult errors, Model model) throws Exception {
		validator.validate(command, errors);
		if (errors.hasErrors()){
			model.addAttribute("inters", command.getInters());
			return "/Validation_10/Index.jsp";
		}
		command.setSelf(command.getSelf().replace("\r\n", "<br />"));
		model.addAttribute("command", command);
		return "/Validation_10/Success.jsp";
	}
}
