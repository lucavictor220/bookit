package com.utm.pad.repositories;


import com.utm.pad.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
}
