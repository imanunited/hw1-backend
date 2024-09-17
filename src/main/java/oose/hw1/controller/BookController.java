package oose.hw1.controller;


import oose.hw1.common.dto.BookDTO;
import oose.hw1.common.result.Result;
import oose.hw1.common.vo.BookVO;
import oose.hw1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result add(@RequestBody BookDTO bookDTO) {

        bookService.addBookById(bookDTO);
        return Result.success();
    }
    @GetMapping("/search")
    public Result<List<BookVO>> get(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String isbn
    ) {
        List <BookVO> List = bookService.getAllBook(title, author, isbn);
        return Result.success(List);
    }

}
