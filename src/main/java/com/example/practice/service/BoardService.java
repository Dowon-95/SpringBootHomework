package com.example.practice.service;

import com.example.practice.entity.Board;
import com.example.practice.dto.BoardDTO;
import com.example.practice.respository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void save(BoardDTO dto) {
        Board boards = dto.toEntity();
        boardRepository.save(boards);
    }

    @Transactional
    public List<Board> show() {
       return boardRepository.findAll();
    }


    @Transactional
    public void delete(Long id){
        boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없어")
        );
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, BoardDTO dto){
        Board target = boardRepository.findById(id).orElse(null);
        if ( target != null){
            target.setTitle(dto.getTitle());
            target.setContent(dto.getContent());
            target.setAuthor(dto.getAuthor());
        }
    }
}
