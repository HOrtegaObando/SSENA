
package com.ke_detalles.SSENA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ke_detalles.SSENA.entity.User;
import com.ke_detalles.SSENA.services.Userservice;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private Userservice userService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody User signupRequest) {
		// verifico si el nombre de usuario está en uso
		if (userService.findUserByAccount(signupRequest.getUsername()) != null) {
			return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso");
		}
		if (!signupRequest.getPassword().equals(signupRequest.getConfirmPassword())) {
			return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
		}

		User newUser = new User();
		newUser.setUsername(signupRequest.getUsername());
		newUser.setPassword(signupRequest.getPassword());

		User savedUser = userService.saveUser(newUser);

		return ResponseEntity.ok(savedUser);

	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User userRequest) {
		User user = userService.getUserAndPassword(userRequest);
		if (userService.getUserAndPassword(userRequest) == null) {
			return ResponseEntity.badRequest().body("Usario o contraseña no coinciden");
		}

		return ResponseEntity.ok(user);

	}
}