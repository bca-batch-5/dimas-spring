package Api.tugas.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.dto.KecamatanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Kecamatan;
import Api.tugas.repository.KecamatanRepo;
import Api.tugas.service.KecamatanService;
import Api.tugas.validator.KecamatanValidator;

@Service
@Transactional
public class KecamatanImpl implements KecamatanService{

    @Autowired
    KecamatanRepo kecamatanRepo;

    @Autowired
    KecamatanValidator kecamatanValidator;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> createKec(KecamatanDto kecamatanDto) {
        Kecamatan kecamatan = new Kecamatan(kecamatanDto.getKodeKecamatan(), kecamatanDto.getKecamatan());
        kecamatanRepo.save(kecamatan);
        String message = kecamatan.getKecamatan() + " berhasil ditambahkan";
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), message, kecamatan);
        return responseData;
    }

    @Override
    public ResponseData<Object> getAllKec(Integer code) {
        responseData = kecamatanValidator.getKecValidation(code);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateKec(Integer code, KecamatanDto kecamatanDto) {
        Kecamatan kecamatanOpt = kecamatanRepo.findByCodeKec(code);
        responseData = kecamatanValidator.updateKecValidation(kecamatanOpt, kecamatanDto);
        return responseData;
    }

    @Override
    public ResponseData<Object> deleteKec(Integer code) {
        Kecamatan kecamatanOpt = kecamatanRepo.findByCodeKec(code);
        responseData = kecamatanValidator.deleteKecValidation(kecamatanOpt);
        return responseData;
    }
    
}
