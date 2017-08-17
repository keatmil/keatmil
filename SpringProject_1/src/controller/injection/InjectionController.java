package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InjectionController {
	
	private Person per1;

	public InjectionController(Person per1) {
		this.per1 = per1;
	}
	/*public void setPer1(Person per1) {
		this.per1 = per1;
	}*/
	
	@RequestMapping("/Injection/Injection.do")
	public String execute(@RequestParam Map map, Map dismap) throws Exception {
		
		per1.setName(map.get("name").toString());
		per1.setAddr(map.get("addr").toString());
		per1.setAge(Integer.parseInt(map.get("age").toString()));
		
		dismap.put("personInfo", per1);
		
		return "forward:/Injection_06/Injection.jsp";
	}
}
