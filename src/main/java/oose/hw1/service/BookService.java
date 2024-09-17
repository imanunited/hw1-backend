package oose.hw1.service;

import oose.hw1.common.dto.BookDTO;
import oose.hw1.common.vo.BookVO;

import java.util.List;

public interface BookService {
    void addBookById(BookDTO bookDTO);

    List<BookVO> getAllBook(String title, String author, String isbn);


}
