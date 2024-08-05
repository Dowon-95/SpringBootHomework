package com.example.practice.controller;


import com.example.practice.entity.Board;
import com.example.practice.dto.BoardDTO;
import com.example.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
		boardService.save(dto);
		return new ResponseEntity<>("board저장", HttpStatus.OK);
	}

	@GetMapping("/board/{paging}")
	public ResponseEntity<Page<Board>> showUsers( @RequestParam(value = "page", defaultValue = "0")int page){
		Page<Board> paging = this.boardService.getList(page);
		return new ResponseEntity<>(paging, HttpStatus.OK);

	}

	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		boardService.delete(id);
		return new ResponseEntity<>("board삭제", HttpStatus.OK);
	}

	@PostMapping("/board/{id}")
	public ResponseEntity<String> updateUsers(@PathVariable Long id,@RequestBody BoardDTO dto){
		boardService.update(id,dto);
		return new ResponseEntity<>("board저장",HttpStatus.OK);
	}


	
	
}
