package com.test.controller;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutorialspoint.login.beans.User;
import com.tutorialspoint.login.controller.RegistrationController;
import com.tutorialspoint.login.service.UserService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;
public class LoginTestController {
	/*Sample test case
	 * @Test
	public void testTheMethodShowAllGreetingsShouldReturnAResult() {
                //GIVEN		
		GreetingService fakeGreetingService = mock(GreetingService.class);
		GreetingController controller = new GreetingController(fakeGreetingService);
		Map<String, Object> model = new HashMap<String, Object>();
                //WHEN
	        String result = controller.showAllGreetings(model);
                //THEN
	        assertNotNull(result);
	        assertEquals("greetings",result);
	}*/
	@Test
	public void testRegisterController() {
		UserService fakeUserService = mock(UserService.class);
		RegistrationController fakeRegCtrl = new RegistrationController();
		User user = new User();
    	user.setFirstname("Teena");
    	user.setLastname("Teena");
    	user.setUsername("TeenaTeena");
    	user.setEmail("teena@email.com");
    	user.setAddress("123 plano road");
    	user.setPassword("hello");
    	user.setPhone(1231231234L);
    	ModelAndView mav = fakeRegCtrl.addUser(user);
    	//assertNotNull(mav);
	}
}
