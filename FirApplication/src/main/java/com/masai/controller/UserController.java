package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.CurrentUserSession;
import com.masai.model.FIR;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {

	@Autowired
	private UserService uService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) {

		User rUser = uService.registerUser(user);

		return new ResponseEntity<User>(rUser, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> userLoginHandler(@Valid @RequestBody LoginDTO user) {

		CurrentUserSession rUser = uService.userLogin(user);

		return new ResponseEntity<CurrentUserSession>(rUser, HttpStatus.OK);

	}

	@GetMapping("/{userId}/fir")
	public ResponseEntity<List<FIR>> getAllFIRHandler(@PathVariable("userId") String key) {

		List<FIR> fir = uService.getAllFIR(key);

		return new ResponseEntity<List<FIR>>(fir, HttpStatus.OK);

	}

	@DeleteMapping("/{userId}/fir/{firId}")
	public ResponseEntity<String> withdrawFirHandler(@PathVariable("userId") String key,
			@PathVariable("firId") Integer fId) {

		String msg = uService.withdrawFir(key, fId);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
