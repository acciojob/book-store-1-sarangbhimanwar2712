package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository ;

    public Book createBook(Book book){
       return bookRepository.addBook(book);
    }

    public Book getBook(int id){
        return bookRepository.getBook(id) ;
    }

    public void deleteBookById(int id){
        bookRepository.deleteBookById(id) ;
    }
    public void deleteAllBooks(){
        bookRepository.deleteAllBooks() ;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks() ;
    }

    public List<Book> getBookByAuthor(String auname){
        return bookRepository.getBookByAuthor(auname) ;
    }
    public List<Book> getBookByGenre(String gnname){
        return bookRepository.getBookByGenre(gnname) ;
    }
}
