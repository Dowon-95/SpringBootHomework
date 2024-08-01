package com.example.practice.dto;

import com.example.practice.entity.Board;
import lombok.Getter;

@Getter
public class BoardDTO {
    private String title;
    private String content;
    private String author;

    public Board toEntity() {
        return new Board(title, content, author);
    }

}
