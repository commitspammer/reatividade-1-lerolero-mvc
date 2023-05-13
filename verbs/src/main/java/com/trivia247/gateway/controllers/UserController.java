package com.trivia247.gateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.trivia247.gateway.services.NicknameService;

@RestController
@RequestMapping("/users")
public class UserController {

	private record UserDTO(String nickname, String token) {};
	private record NicknameDTO(String nickname) {};

	@Autowired
	private NicknameService nicknameService;

	@PostMapping
	public UserDTO post(@RequestBody NicknameDTO nicknameDTO) {
		String token = nicknameService.registerNickname(nicknameDTO.nickname());
		return new UserDTO(nicknameDTO.nickname(), token);
	}

	@GetMapping("/{token}")
	public UserDTO get(@PathVariable String token) {
		String nickname = nicknameService.retrieveNickname(token);
		return new UserDTO(nickname, token);
	}

}
