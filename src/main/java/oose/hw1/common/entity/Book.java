package oose.hw1.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private Long id;  // 新增的id字段
    private String title;
    private String author;
    private String isbn;
    private Long userId;


}

