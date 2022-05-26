package Api.tugas.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.KecamatanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Kecamatan;
import Api.tugas.repository.KecamatanRepo;

@Service
public class KecamatanValidator {

    ResponseData<Object> responseData;

    @Autowired
    KecamatanRepo kecamatanRepo;
    
    public ResponseData<Object> getKecValidation(Integer code) {
        if (code == null) {
            List<Kecamatan> kecamatan = kecamatanRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", kecamatan);
            return responseData;
        } else {
            Kecamatan kecamatanOpt = kecamatanRepo.findByCodeKec(code);
            if (kecamatanOpt != null) {
                Kecamatan kecamatan = kecamatanOpt;
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", kecamatan);
                return responseData;
            } else {
                throw new DataNotFoundException("Data kecamatan tidak ditemukan!");
            }
        }
    }

    public ResponseData<Object> updateKecValidation(Kecamatan kecamatanOpt,KecamatanDto kecamatanDto) {
        if (kecamatanOpt != null) {
            Kecamatan kecamatan = kecamatanOpt;
            kecamatan.setCodeKec(kecamatanDto.getKodeKecamatan());
            kecamatan.setKecamatan(kecamatanDto.getKecamatan());
            kecamatanRepo.save(kecamatan);
            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "data berhasil diupdate", kecamatan);
            return responseData;
        } else {
            throw new DataNotFoundException("data kecamatan tidak ditemukan");
        }
    }

    public ResponseData<Object> deleteKecValidation(Kecamatan kecamatanOpt) {
        if (kecamatanOpt != null) {
            Kecamatan kecamatan = kecamatanOpt;
            kecamatan.setIsDeleted(true);
            kecamatanRepo.save(kecamatan);
            responseData = new ResponseData<Object>(HttpStatus.ACCEPTED.value(), "data berhasil dihapus", null);
            return responseData;
        } else {
            throw new DataNotFoundException("data kecamatan tidak ditemukan");
        }
    }
}
