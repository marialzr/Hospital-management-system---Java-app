package com.fortech.hospital;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.fortech.model.Patient;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    

	/*@RequestMapping(method = RequestMethod.GET, value = "/test2")
	public List<Patient> getAllPatients() {
		System.out.println("zzz Here");
		return new ArrayList<>();
	}*/

}
