package Api.tugas.service;


import Api.tugas.dto.PeminjamanDto;
import Api.tugas.dto.ResponseData;

public interface PeminjamanService {
    ResponseData<Object> addPeminjaman(PeminjamanDto peminjamanDto);
    ResponseData<Object> endPeminjaman(Integer id);
}
