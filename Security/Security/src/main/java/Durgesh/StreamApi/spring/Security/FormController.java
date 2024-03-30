package Durgesh.StreamApi.spring.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FormController {
	
	@GetMapping("/signin")
	public String login()
	{
		return "mylogin.html";
	}

}
