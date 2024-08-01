package com.example.practice.controller;


import com.example.practice.entity.Users;
import com.example.practice.dto.UserDTO;
import com.example.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/users")
	public ResponseEntity<String> save(@RequestBody UserDTO dto) {
		return userService.save(dto);

	}

	@GetMapping("/users")
	public List<Users>  showUsers(){
		return  userService.show();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return userService.delete(id);
	}

	@PostMapping("/users/{id}")
	public ResponseEntity<String> updateUsers(@PathVariable Long id,@RequestBody UserDTO dto){
		return userService.update(id,dto);

	}


	
	
}
