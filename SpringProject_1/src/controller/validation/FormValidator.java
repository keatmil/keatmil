package controller.validation;

import java.util.StringTokenizer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FormValidator implements Validator{

	@Override
	public boolean supports(Class<?> command) {
		// TODO Auto-generated method stub
		//return FormCommand.class.isAssignableFrom(command);
		return FormCommand.class.equals(command);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		// TODO Auto-generated method stub
		FormCommand command = (FormCommand)cmd;
		
		if (command.getName().trim().equals("")){
			
			errors.rejectValue("name", "nameError");
		}
		if (command.getYears().trim().equals("")){
			errors.rejectValue("years", "yearsError");
		} else {
			try {
				Integer.parseInt(command.getYears().trim());
			} catch (Exception e) {
				errors.rejectValue("years", "yearsNotNumberError");
			}
		}
		if (command.getGender() == null){
			errors.rejectValue("gender", "genderError");
		} 
		
		if (command.getInters() == null){
			errors.rejectValue("inters", "intersError");
		} else {
			StringTokenizer tokens = new StringTokenizer(command.getInters(), ",");
			if (tokens.countTokens() < 2){
				errors.rejectValue("inters", "intersLackError");
			}
		}
		if (command.getGrade().equals("")){
			errors.rejectValue("grade", "gradeError");
		} 
		if (command.getSelf().trim().equals("")){
			errors.rejectValue("self", "selfError");
		} 
	}

}
