package com.becks.trivial.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.becks.trivial.models.User;
import com.becks.trivial.services.UserService;
import com.becks.trivial.validators.UserValidator;

@Controller
public class UserController {
private final UserService userService;
	
	private final UserValidator userValidator; 
	 
	public UserController(UserService userService, UserValidator userValidator) {
	    this.userService = userService;
	    this.userValidator = userValidator; 
	}
	 
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard"; 
		}
		return "registration.jsp";
	}
	
	@RequestMapping("/")
	public String login(HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard"; 
		}
	    return "login.jsp";
	}
	 
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
		// if result has errors, return the registration page (don't worry about validations just now)
		if(result.hasErrors()) {
			return "registration.jsp"; 
		}
		// else, save the user in the database, save the user id in session, and redirect them to the /home route
		userService.registerUser(user); 
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard"; 
	}
	 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	// if the user is authenticated, save their user id in session
		if(userService.authenticateUser(email, password)) {
			User currentUser = userService.findByEmail(email); 
			session.setAttribute("user_id", currentUser.getId());
		} else {
		// else, add error messages and return the login page
			model.addAttribute("error", "Sorry! User not found."); 
			return "login.jsp"; 
		}
		
		return "redirect:/dashboard"; 
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	// invalidate session
		session.invalidate(); 
	// redirect to login page
		return "redirect:/"; 
	}
}
