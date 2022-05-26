package Api.tugas.service;

import Api.tugas.dto.ProvinsiDto;
import Api.tugas.dto.ResponseData;


public interface ProvService {
    ResponseData<Object> createProv(ProvinsiDto dto);

    ResponseData<Object> getAllProv(Integer code);

    ResponseData<Object> updateProv(Integer code, ProvinsiDto provinsiDto);

    ResponseData<Object> deletePRov(Integer code);
}
