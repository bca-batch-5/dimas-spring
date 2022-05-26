package Api.tugas.service;


import Api.tugas.dto.KelurahanDto;
import Api.tugas.dto.ResponseData;

public interface KelurahanService {
    ResponseData<Object> createKelurahan(KelurahanDto kelurahanDto);
    ResponseData<Object> getKelurahan(Integer code);
    ResponseData<Object> updateKelurahan(Integer code, KelurahanDto kelurahanDto);
    ResponseData<Object> deleteKelurahan(Integer code);
}
