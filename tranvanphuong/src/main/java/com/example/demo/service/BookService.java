package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<BookEntity> getAllBook(Pageable pageable);
    int getTotalPage(Pageable pageable);
    BookEntity getBookById(int id);
    BookEntity createBook(BookEntity p);
}
