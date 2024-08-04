package com.example.practice.controller;


import com.example.practice.entity.Users;
import com.example.practice.dto.UserDTO;
import com.example.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

		if(!dto.getEmail().contains("@")){
			return new ResponseEntity<>("실패 : 이메일에 @가 포함되지 않았음",HttpStatus.BAD_REQUEST);
		}
		userService.save(dto);
		return new ResponseEntity<>("저장", HttpStatus.OK);

	}

	@GetMapping("/users")
	public List<Users>  showUsers(){
		return userService.show();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<>("삭제", HttpStatus.OK);
	}

	@PostMapping("/users/{id}")
	public ResponseEntity<String> updateUsers(@PathVariable Long id,@RequestBody UserDTO dto){
		if(!dto.getEmail().contains("@")){
			return new ResponseEntity<>("실패 : 이메일에 @가 포함되지 않았음",HttpStatus.BAD_REQUEST);
		}
		userService.update(id,dto);
		return new ResponseEntity<>("저장",HttpStatus.OK);
	}


	
	
}
