package Api.tugas.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.dto.KelurahanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Kelurahan;
import Api.tugas.repository.KelurahanRepo;
import Api.tugas.service.KelurahanService;
import Api.tugas.validator.KelurahanValidator;

@Service
public class KelurahanServiceImpl implements KelurahanService{

    @Autowired
    KelurahanRepo kelurahanRepo;

    @Autowired
    KelurahanValidator kelurahanValidator;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> createKelurahan(KelurahanDto kelurahanDto) {
        Kelurahan kelurahan = new Kelurahan( kelurahanDto.getKodeKelurahan(), kelurahanDto.getKelurahan());
        kelurahanRepo.save(kelurahan);
        String message = kelurahan.getKelurahan() + " berhasil ditambahkan";
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), message, kelurahan);
        return responseData;
    }

    @Override
    public ResponseData<Object> getKelurahan(Integer code) {
        responseData = kelurahanValidator.getKelurahanValidation(code);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateKelurahan(Integer code, KelurahanDto kelurahanDto) {
        Kelurahan kelurahanOpt =kelurahanRepo.findByCodeKel(code);
        responseData = kelurahanValidator.updateKelValidation(kelurahanOpt, kelurahanDto);
        return responseData;
    }

    @Override
    public ResponseData<Object> deleteKelurahan(Integer code) {
        Kelurahan kelurahanOpt =kelurahanRepo.findByCodeKel(code);
        responseData = kelurahanValidator.deleteKelValidation(kelurahanOpt);
        return responseData;
    }
    
}
