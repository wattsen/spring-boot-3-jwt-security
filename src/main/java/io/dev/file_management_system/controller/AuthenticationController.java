package io.dev.file_management_system.controller;

import io.dev.file_management_system.dto.AuthenticationRequest;
import io.dev.file_management_system.dto.AuthenticationResponse;
import io.dev.file_management_system.dto.RegistrationRequest;
import io.dev.file_management_system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<AuthenticationResponse> signUp(@RequestBody RegistrationRequest request) {
		return ResponseEntity.ok(authService.register(request));


	}

	@PostMapping("/signin")
	public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authService.authenticate(request));

	}
}
