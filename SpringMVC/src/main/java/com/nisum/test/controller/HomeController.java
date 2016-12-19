package com.nisum.test.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.test.dto.ServiceMessages;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.nisum.test.*"})
public class HomeController {
	
@Autowired
private ServiceMessages serviceMessage;
	
@RequestMapping(value = "/", method = RequestMethod.GET)
public String getHomePage(ModelMap modelMap, HttpSession httpSession){
	System.out.println(serviceMessage.getStudentUrl());
	httpSession.setAttribute("serviceMessage", serviceMessage.getStudentUrl());
	return "home";
}

@RequestMapping(value= "/user", method = RequestMethod.GET)
public Principal user(Principal principal) {
	/*System.out.println(principal.getName());
	System.out.println(principal.getClass());*/
  return principal;
}

@RequestMapping(value = "/admin", method = RequestMethod.GET)
public String getHelloPage(){
	
	return "admin";
}

@RequestMapping(value = "/login", method = RequestMethod.GET)
public String getLoginPage(){
	
	return "login";
}

}
