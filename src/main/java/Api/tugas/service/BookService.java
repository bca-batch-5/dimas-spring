package Api.tugas.service;



import Api.tugas.dto.BookDto;
import Api.tugas.dto.ResponseData;

public interface BookService {
    ResponseData<Object> createBook(BookDto bookDto);
    ResponseData<Object> getBook(Integer id);
    ResponseData<Object> updateBook(Integer id, BookDto bookDto);
    ResponseData<Object> deleteBook(Integer id);
}
