package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    @Autowired
    BookService bookService ;
    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book) ;
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable("id")int id){
        Book book = BookService.bookRepository.getBook(id); ;
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return new ResponseEntity("Deleted" ,HttpStatus.ACCEPTED) ;
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-book")
    public ResponseEntity getAllBooks(){
        List st = bookService.getAllBooks() ;
        return new ResponseEntity<>(st, HttpStatus.ACCEPTED) ;
    }


    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity delteAllBooks(){
        bookService.deleteAllBooks() ;
        return new ResponseEntity("All books deleted" ,HttpStatus.ACCEPTED) ;
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("name") String name){
        List<Book> list = bookService.getBookByAuthor(name) ;
        return new ResponseEntity<>(list ,HttpStatus.ACCEPTED) ;
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam("grname") String grname){
        List<Book> list =  bookService.getBookByGenre(grname) ;
        return new ResponseEntity<>(list ,HttpStatus.ACCEPTED) ;
    }
}
