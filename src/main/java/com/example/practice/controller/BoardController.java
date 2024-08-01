package com.example.practice.controller;


import com.example.practice.entity.Board;
import com.example.practice.dto.BoardDTO;
import com.example.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	private BoardService boardService;


	@PostMapping("/board")
	public ResponseEntity<String> save(@RequestBody BoardDTO dto) {
		return boardService.save(dto);

	}

	@GetMapping("/board")
	public List<Board>  showUsers(){
		return  boardService.show();
	}

	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return boardService.delete(id);
	}

	@PostMapping("/board/{id}")
	public ResponseEntity<String> updateUsers(@PathVariable Long id,@RequestBody BoardDTO dto){
		return boardService.update(id,dto);

	}


	
	
}
