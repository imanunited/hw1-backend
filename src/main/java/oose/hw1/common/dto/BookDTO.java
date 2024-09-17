package oose.hw1.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {
    String title;
    String author;
    String isbn;
}
