package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<BookEntity> getAllBook(Pageable pageable) {
        return bookRepo.findAll(pageable).getContent();
    }

    @Override
    public int getTotalPage(Pageable pageable) {
        return bookRepo.findAll(pageable).getTotalPages();
    }

    @Override
    public BookEntity getBookById(int id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public BookEntity createBook(BookEntity p) {
        return bookRepo.save(p);
    }
}
