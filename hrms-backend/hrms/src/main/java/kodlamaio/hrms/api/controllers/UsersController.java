package kodlamaio.hrms.api.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Transactional
	@PostMapping("/updatePassword")
	public Result updateUserSetPassword(@RequestParam("userId") int userId, @RequestParam("password") String password,
			@RequestParam("passwordAgain") String passwordAgain) {
		return this.userService.updateUserSetPassword(userId, password, passwordAgain);
	}

}