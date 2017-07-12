package com.nisum.test.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nisum.test.dto.ServiceMessages;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.nisum.test.*" })
public class HomeController2 {

	@Autowired
	private ServiceMessages serviceMessage;

	@Autowired
	private TokenStore tokenStore;

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap, HttpSession httpSession) {
		System.out.println(serviceMessage.getStudentUrl());
		httpSession.setAttribute("serviceMessage", serviceMessage.getStudentUrl());
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Principal principal, ModelMap modelMap, HttpSession httpSession, HttpServletRequest httpRequest,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	         new SecurityContextLogoutHandler().logout(httpRequest, response, auth);
	      }
	    SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/";
	}

	

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getHelloPage() {

		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {

		return "login";
	}

}
