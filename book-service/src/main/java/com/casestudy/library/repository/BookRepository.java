package com.casestudy.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.library.bean.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
