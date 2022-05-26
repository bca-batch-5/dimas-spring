package Api.tugas.service.Implement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.dto.ResponseData;
import Api.tugas.dto.request.KabKotDto;
import Api.tugas.model.KabupatenKota;
import Api.tugas.model.Provinsi;
import Api.tugas.repository.KabKotRepo;
import Api.tugas.repository.ProvinsiRepo;
import Api.tugas.service.KabKotService;
import Api.tugas.validator.KabKotValidator;

@Service
@Transactional
public class KabKotServiceImpl implements KabKotService {

    @Autowired
    KabKotRepo kabKotRepo;
    
    @Autowired
    ProvinsiRepo provinsiRepo;

    @Autowired
    KabKotValidator kabKotValidator;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> createKab(KabKotDto kabKotDto) {
        Provinsi provinsi =  provinsiRepo.findByprovCode(kabKotDto.getKodeProvinsi());
        KabupatenKota kabupatenKota = new KabupatenKota(kabKotDto.getKodeKabupatenKota(), kabKotDto.getKabupatenKota(),provinsi);
        kabKotRepo.save(kabupatenKota);
        String message = kabupatenKota.getKabKot() + " berhasil ditambahkan";
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(),message, kabupatenKota);
        return responseData;        
    }

    @Override
    public ResponseData<Object> getAllKab(Integer code) {
        responseData = kabKotValidator.getKabKotValidation(code);
        return responseData;

    }

    @Override
    public void getKabByProv() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateKab() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteKab() {
        // TODO Auto-generated method stub

    }

}
