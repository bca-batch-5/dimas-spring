package Api.tugas.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.dto.BookDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Book;
import Api.tugas.repository.BookRepo;
import Api.tugas.service.BookService;
import Api.tugas.validator.BookValidation;

@Service
@Transactional
public class BookImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookValidation bookValidation;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> createBook(BookDto bookDto) {
        Book book = new Book(bookDto.getJudul(), bookDto.getPenulis());
        bookRepo.save(book);
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Buku berhasil ditambahkan", book);
        return responseData;
    }

    @Override
    public ResponseData<Object> getBook(Integer id) {
        responseData = bookValidation.getBookValidation(id);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateBook(Integer id, BookDto bookDto) {
        responseData = bookValidation.updateBookValidation(id, bookDto);
        return responseData;
    }

    @Override
    public ResponseData<Object> deleteBook(Integer id) {
        responseData = bookValidation.deleteBookValidation(id);
        return responseData;
    }

}
