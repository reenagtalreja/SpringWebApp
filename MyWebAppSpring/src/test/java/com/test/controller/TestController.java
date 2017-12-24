package com.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import javax.sql.DataSource;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import com.tutorialspoint.HelloController;
import com.tutorialspoint.login.beans.Login;
import com.tutorialspoint.login.beans.User;
import com.tutorialspoint.login.service.UserService;

import junit.framework.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/WEB-INF/SpringFormEmployeeExample-servlet.xml"})
public class TestController {
	 @Autowired
 	  public UserService userService;	
	/*
	 * This is used for dao service layer
	 * 
	 * @Configuration static class TestControllerContextConfiguration {
	 * 
	 * @Bean public AccountService accountService() { return new
	 * AccountServiceImpl(); } } //We Autowired the AccountService bean so that it
	 * is injected from the configuration
	 * 
	 * @Autowired private AccountService accountService;
	 * 
	 * @Before public void setup() { Account account = new AccountBuilder() { {
	 * address("Herve", "4650", "Rue de la gare", "1", null, "Belgium");
	 * credentials("john", "secret"); name("John", "Doe"); } }.build(true);
	 * Mockito.when(accountRepository.findByUsername("john")).thenReturn(account); }
	 * 
	 * @Test(expected = AuthenticationException.class) public void
	 * testLoginFailure() throws AuthenticationException {
	 * accountService.login("john", "fail"); }
	 * 
	 * @Test() public void testLoginSuccess() throws AuthenticationException {
	 * Account account = accountService.login("john", "secret");
	 * assertEquals("John", account.getFirstName()); assertEquals("Doe",
	 * account.getLastName()); } }
	 * https://krishnasblog.com/2013/02/21/junit-testing-of-spring-mvc-application-
	 * testing-service-layer/

	static class TestControllerContextConfiguration {
		@Bean
		public HelloController helloController() {
			return new HelloController();
		}
	}
	@Autowired
	private HelloController helloController;
	@Test
	public void testHandleLogin() throws Exception {
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.helloController).build();
	this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
    .andExpect(content().string(containsString("Hello World")));
	}*/
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Test
    public void registerTest() {
    	User user = new User();
    	user.setFirstname("Teena");
    	user.setLastname("Teena");
    	user.setUsername("TeenaTeena");
    	user.setEmail("teena@email.com");
    	user.setAddress("123 plano road");
    	user.setPassword("hello");
    	user.setPhone(1231231234L);
    	userService.register(user);
    	Login login = new Login();
    	login.setUsername(user.getUsername());
    	login.setPassword(user.getPassword());
    	User newUser = userService.validateUser(login);
    	Assert.assertEquals(newUser.getFirstname(), user.getFirstname());
    }
}
