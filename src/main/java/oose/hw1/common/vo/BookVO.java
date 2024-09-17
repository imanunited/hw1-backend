package oose.hw1.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookVO implements Serializable {
    String title;
    String author;
    String isbn;
}
