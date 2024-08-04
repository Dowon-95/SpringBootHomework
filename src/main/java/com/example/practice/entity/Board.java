package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "S_Board")
public class Board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String author;
    @Column
    private Date date;

    public Board(String title, String content, String author) {
        this.title=title;
        this.content=content;
        this.author = author;
        this.date = new Date();
    }
}
