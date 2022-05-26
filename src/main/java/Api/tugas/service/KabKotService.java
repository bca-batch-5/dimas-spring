package Api.tugas.service;

import Api.tugas.dto.ResponseData;
import Api.tugas.dto.request.KabKotDto;

public interface KabKotService {
    public ResponseData<Object> createKab(KabKotDto kabKotDto);

    ResponseData<Object> getAllKab(Integer code);

    void getKabByProv();

    void updateKab();

    void deleteKab();
}
