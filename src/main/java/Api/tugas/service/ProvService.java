package Api.tugas.service;

import Api.tugas.dto.ProvinsiDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Provinsi;

public interface ProvService {
    ResponseData<Object> createProv(ProvinsiDto dto);

    ResponseData<Object> getAllProv(Provinsi code);

    ResponseData<Object> updateProv(Provinsi code, ProvinsiDto provinsiDto);

    ResponseData<Object> deletePRov(Provinsi code);
}
