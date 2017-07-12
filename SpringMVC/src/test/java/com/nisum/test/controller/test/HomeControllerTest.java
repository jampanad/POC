package com.nisum.test.controller.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nisum.test.controller.HomeController;
import com.nisum.test.dto.ServiceMessages;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SecurityContextHolder.class)
public class HomeControllerTest {
	
	@Mock
	private ServiceMessages serviceMessage;
	
	@InjectMocks
	private HomeController homeController;
	
	@Mock
	ModelMap modelMap;
	
	@Mock
	HttpSession httpSession;
	
	@Mock
	SecurityContext securityContext;
	
	@Mock
	HttpServletRequest httpRequest;
	
	@Mock 
	HttpServletResponse response;
	
	@Mock
	Authentication auth;
	
	@Mock
	Principal principal;
	
	@Mock
	private TokenStore tokenStore;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/jsp/view/");
	        viewResolver.setSuffix(".jsp");

	        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
	                                 .setViewResolvers(viewResolver)
	                                 .build();
	}
	
	@Test
	public void tokenStoreTest() {
		TokenStore tokenStore = homeController.tokenStore();
		Assert.assertNotNull(tokenStore);
	}
	
	@Test
	public void getHomePageTest() throws Exception{
		when(serviceMessage.getStudentUrl()).thenReturn("abc");
        ResultActions result = mockMvc.perform(get("/"));
        result.andExpect(status().isOk());
		/*String result = homeController.getHomePage(modelMap, httpSession);
		Assert.assertNotNull(result);*/
		
	}
	
	@Test
	public void logoutAuthNullTest() throws Exception{
		PowerMockito.mockStatic(SecurityContextHolder.class);
		//PowerMockito.mockStatic(SecurityContext.class);
        BDDMockito.given(SecurityContextHolder.getContext()).willReturn(securityContext);
        when(securityContext.getAuthentication()).thenReturn(auth);
		 ResultActions result = mockMvc.perform(get("/logout"));
	        result.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void logoutAuthHeadersTest() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/logout").header("Authorization", "my value"));
        result.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void getHelloPageTest() throws Exception{
		ResultActions result = mockMvc.perform(get("/admin"));
		result.andExpect(status().isOk());
	}
	
	@Test
	public void getLoginPageTest() throws Exception{
		ResultActions result = mockMvc.perform(get("/login"));
		result.andExpect(status().isOk());
	}
	
}
