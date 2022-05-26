package Api.tugas.service;

import Api.tugas.dto.KabKotDto;
import Api.tugas.dto.ResponseData;

public interface KabKotService {
    public ResponseData<Object> createKab(KabKotDto kabKotDto);

    ResponseData<Object> getAllKab(Integer code);

    void getKabByProv();

    void updateKab();

    void deleteKab();
}
