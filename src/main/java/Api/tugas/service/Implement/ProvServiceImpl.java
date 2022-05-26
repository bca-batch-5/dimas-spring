package Api.tugas.service.Implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.dto.ProvinsiDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Provinsi;
import Api.tugas.repository.ProvinsiRepo;
import Api.tugas.service.ProvService;
import Api.tugas.validator.ProvValidator;

@Service
@Transactional
public class ProvServiceImpl implements ProvService {
    private ResponseData<Object> responseData;
    @Autowired
    private ProvinsiRepo provinsiRepo;
    @Autowired
    private ProvValidator provValidator;

    @Override
    public ResponseData<Object> createProv(ProvinsiDto dto) {
        Provinsi provinsi = new Provinsi(dto.getKodeProvinsi(), dto.getProvinsi());
        provinsiRepo.save(provinsi);
        String message = dto.getProvinsi() + " telah berhasil ditambahkan";
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), message, provinsi);
        return responseData;
    }

    @Override
    public ResponseData<Object> getAllProv(Provinsi code) {
        responseData = provValidator.getProvValidation(code);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateProv(Provinsi code, ProvinsiDto provinsiDto) {
        Provinsi provinsiOpt = provinsiRepo.findByprovCode(code);
        responseData = provValidator.updateProvValidation(provinsiOpt, provinsiDto);
        return responseData;
    }

    @Override
    public ResponseData<Object> deletePRov(Provinsi code) {
        Provinsi provinsiOpt = provinsiRepo.findByprovCode(code);
        responseData = provValidator.deleteProvValidation(provinsiOpt);
        return responseData;
    }

}
