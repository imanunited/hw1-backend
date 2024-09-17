package oose.hw1.service.impl;

import oose.hw1.common.dto.BookDTO;
import oose.hw1.common.entity.Book;
import oose.hw1.common.vo.BookVO;
import oose.hw1.mapper.BookMapper;
import oose.hw1.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    public void addBookById(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);

        Book existingBook = bookMapper.findByIsbn(book.getIsbn());
        if (existingBook != null) {
            throw new IllegalArgumentException("This Book already exists in the system.");
        }

        book.setUserId(10L);

        bookMapper.insertBook(book);

    }
    public List<BookVO> getAllBook(String title, String author, String isbn) {
        List<Book> books = bookMapper.getBook(title, author, isbn);
        List<BookVO> bookVOs = new ArrayList<>();


        for (Book book : books) {
            BookVO bookVO = new BookVO();
            BeanUtils.copyProperties(book, bookVO); // 使用 Spring 的 BeanUtils 进行属性拷贝
            bookVOs.add(bookVO); // 将转换后的 BookVO 对象添加到列表中
        }

        return bookVOs;
    }


}
