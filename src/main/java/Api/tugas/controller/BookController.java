package Api.tugas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Api.tugas.dto.BookDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    ResponseData<Object> responseData;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody BookDto bookDto){
        responseData = bookService.createBook(bookDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestParam(value = "id", defaultValue = "")Integer id){
        responseData = bookService.getBook(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody BookDto bookDto){
        responseData =bookService.updateBook(id, bookDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id){
        responseData = bookService.deleteBook(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
