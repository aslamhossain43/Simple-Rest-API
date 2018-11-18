package com.renu.s_r_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renu.s_r_api.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
public Book getById(Long id);
}
