package Api.tugas.validator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.BookDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Book;
import Api.tugas.repository.BookRepo;


@Service
public class BookValidation {
    ResponseData<Object> responseData;
    @Autowired
    BookRepo bookRepo;

    public ResponseData<Object> getBookValidation(Integer id){
        if (id == null) {
            List<Book> books = bookRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "Success", books);
            return responseData;
        } else {
            Optional<Book> bookOpt = bookRepo.findById(id);
            if (bookOpt != null) {
                Book book = bookOpt.get();
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "succes", book);
                return responseData;
            } else {
                throw new DataNotFoundException("data tidak ditemukan");
            }
            
        }
    } 

    public ResponseData<Object> updateBookValidation(Integer id, BookDto bookDto){
        Optional<Book> bookOpt = bookRepo.findById(id);
        if (bookOpt != null) {
            Book book = bookOpt.get();
            book.setTitle(bookDto.getJudul());
            book.setAuthor(bookDto.getPenulis());
            bookRepo.save(book);
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "succes", book);
            return responseData;
        } else {
            throw new DataNotFoundException("data tidak ditemukan");
        }
    }

    public ResponseData<Object> deleteBookValidation(Integer id){
        Optional<Book> bookOpt = bookRepo.findById(id);
        if (bookOpt != null) {
            Book book = bookOpt.get();
            book.setIsDeleted(true);
            bookRepo.save(book);
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "data berhasil dihapus", null);
            return responseData;
        } else {
            throw new DataNotFoundException("data tidak ditemukan");
        }
    }
}
