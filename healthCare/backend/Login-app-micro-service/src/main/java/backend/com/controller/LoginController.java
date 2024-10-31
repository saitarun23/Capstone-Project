package backend.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.com.entity.Login;
import backend.com.entity.User;
import backend.com.service.LoginService;
import backend.com.service.UserService;

@RestController
@RequestMapping(value="user")
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String checkUserLogin(@RequestBody Login login) {
		return loginService.checkUserLogin(login);
	}
	
	@PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUserLogin(@RequestBody User user) {
		return loginService.createAccount(user, "user");
	}
	
	@GetMapping(value = "findUser/{email}")
	public User findUser(@PathVariable("email") String email) {
		return userService.findUser(email);
	}
	
	@PutMapping(value = "editUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String editUserDetails(@RequestBody User user) {
		return userService.editUser(user);
	}
	
}
