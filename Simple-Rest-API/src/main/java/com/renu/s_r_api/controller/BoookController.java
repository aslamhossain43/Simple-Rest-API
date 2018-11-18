package com.renu.s_r_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.renu.s_r_api.models.Book;
import com.renu.s_r_api.repositories.BookRepository;

@RestController
public class BoookController {
private static final Logger LOGGER=LoggerFactory.getLogger(BoookController.class);

@Autowired
private BookRepository bookRepository;
//GET MAPPING
@GetMapping(value="/api/book")
public ResponseEntity<List<Book>>getAllBooks(){
	LOGGER.info("FROM CLASS BookController,method : getAllBooks()");
	List<Book>list=bookRepository.findAll();
	return ResponseEntity.ok().body(list);
	
}
//SAVE METHOD
@PostMapping(value="/api/book")
public ResponseEntity<?>addBooks(@RequestBody Book book){
	LOGGER.info("FROM CLASS BookController,method : addBooks()");
	bookRepository.save(book);
	return ResponseEntity.ok().body("Your book has been added successfully !!");

}

//GET BOOK  BY ID
@GetMapping(value="/api/book/{id}")
public ResponseEntity<Book>getBookById(@PathVariable("id")Long id){
	LOGGER.info("FROM CLASS BookController,method : getBookById()");
	Book book=bookRepository.getById(id);
	return ResponseEntity.ok().body(book);
	
}


//UPDATE BY ID
@PutMapping(value="/api/book/{id}")
public ResponseEntity<?>updateById(@PathVariable("id")Long id,@RequestBody Book book){
	Book bookById=bookRepository.getById(id);
	bookById.setTitle(book.getTitle());
	bookById.setAuthor(book.getAuthor());
	bookRepository.save(book);
	
	return ResponseEntity.ok().body("Update has been completed successfully !!");	
}

//DELETE BY ID
@DeleteMapping("/api/book/{id}")
public ResponseEntity<?>deleteById(@PathVariable("id")Long id){
	bookRepository.deleteById(id);
	return ResponseEntity.ok().body(id+" has been deleted successfully !!");
	
}




}
