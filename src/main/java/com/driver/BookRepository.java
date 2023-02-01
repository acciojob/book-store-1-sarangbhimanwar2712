package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {

    HashMap<Integer,Book> bookMap = new HashMap<>() ;
    HashMap<String ,Book> stringBookMap = new HashMap<>() ;

    public Book addBook(Book book){
        int id = book.getId();
        bookMap.put(id,book) ;
        return book ;
    }

    public Book getBook(int id){
        return bookMap.get(id) ;
    }

    public void deleteBookById(int id){
        bookMap.remove(id) ;
    }

    public void deleteAllBooks(){
        bookMap.clear();
    }
    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>() ;
        for(Book b :bookMap.values()){
            bookList.add(b) ;
        }
        return bookList ;
    }

    public List<Book> getBookByAuthor(String auname){
        List<Book> list = new ArrayList<>() ;
        for(Book book :bookMap.values()){
            if(book.getAuthor().equals(auname)) {
                list.add(book) ;
            }
        }
        return list ;
    }

    public List<Book> getBookByGenre(String gnname){
        List<Book> list = new ArrayList<>() ;
        for(Book book :bookMap.values()){
            if(book.getGenre().equals(gnname)) {
                list.add(book) ;
            }
        }
        return list ;
    }
}
