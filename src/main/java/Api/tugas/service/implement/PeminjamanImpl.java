package Api.tugas.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.PeminjamanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Book;
import Api.tugas.model.Peminjaman;
import Api.tugas.model.User;
import Api.tugas.repository.BookRepo;
import Api.tugas.repository.PeminjamanRepo;
import Api.tugas.repository.UserRepo;
import Api.tugas.service.PeminjamanService;

@Service
@Transactional
public class PeminjamanImpl implements PeminjamanService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;
    @Autowired
    PeminjamanRepo peminjamanRepo;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> addPeminjaman(PeminjamanDto peminjamanDto) {
        Optional<User> userOpt = userRepo.findById(peminjamanDto.getUserId());
        Optional<Book> bookOpt = bookRepo.findById(peminjamanDto.getBookId());
        User user = userOpt.get();
        Book book = bookOpt.get();
        Peminjaman peminjaman = new Peminjaman(user, book);
        peminjamanRepo.save(peminjaman);
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "success", peminjaman);
        return responseData;
    }

    @Override
    public ResponseData<Object> endPeminjaman(Integer id) {
        Optional<Peminjaman> peminjamanOpt = peminjamanRepo.findById(id);
        if (peminjamanOpt.isPresent()) {
            Peminjaman peminjaman = peminjamanOpt.get();
            peminjaman.setStatus(true);
            peminjamanRepo.save(peminjaman);
            responseData = new ResponseData<Object>(HttpStatus.ACCEPTED.value(), "Buku telah dikembalikan", peminjaman);
            return responseData;
        } else {
            throw new DataNotFoundException("Data tidak ditemukan");
        }
    }
    
}
