package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.service.AuthorService;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;
    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> index() {
        var books = bookService.getAll();
        return books;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookCreateDTO dto) {
        var book = bookService.add(dto);
        return book;
    }
    @GetMapping(path = "{id}")
    public BookDTO show(@PathVariable long id) {
        var book = bookService.findById(id);
        return book;
    }
    @PutMapping(path = "{id}")
    public BookDTO update(@PathVariable long id,@RequestBody @Valid BookUpdateDTO dto) {
        var book = bookService.update(dto,id);
        return book;
    }
    @DeleteMapping(path = "{id}")
    public void destroy(@PathVariable long id) {
        bookService.delete(id);
    }
    // END
}
