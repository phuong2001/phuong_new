package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    BookService bookService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/list"})
    public String pageableBook(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "1") int size) {
        List<BookEntity> books = bookService.getAllBook(PageRequest.of(page, size));
        int totalPage  = bookService.getTotalPage(PageRequest.of(page, size));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        BookEntity bookEntity = new BookEntity();
        model.addAttribute("book", bookEntity);
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute BookEntity bookEntity, Model model) {
        bookService.createBook(bookEntity);
        return "redirect:/list";
    }
}
