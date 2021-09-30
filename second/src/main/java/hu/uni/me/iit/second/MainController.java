package hu.uni.me.iit.second;

import java.awt.PageAttributes.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping(path="/", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	ResponseDto gyoker() {
		ResponseDto responseDto = new ResponseDto();
		
		responseDto.setId(123);
		responseDto.setMessage("Helloo");
		return responseDto;
		
	}
	
}
