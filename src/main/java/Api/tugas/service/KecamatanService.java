package Api.tugas.service;


import Api.tugas.dto.KecamatanDto;
import Api.tugas.dto.ResponseData;

public interface KecamatanService {
    ResponseData<Object> createKec(KecamatanDto kecamatanDto);

    ResponseData<Object> getAllKec(Integer code);

    ResponseData<Object> updateKec(Integer code, KecamatanDto kecamatanDto);

    ResponseData<Object> deleteKec(Integer code);
}
