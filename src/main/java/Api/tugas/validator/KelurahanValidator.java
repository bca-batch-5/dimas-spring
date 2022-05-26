package Api.tugas.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.KelurahanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Kelurahan;
import Api.tugas.repository.KelurahanRepo;

@Service
public class KelurahanValidator {
    ResponseData<Object> responseData;

    @Autowired
    KelurahanRepo kelurahanRepo;

    public ResponseData<Object> getKelurahanValidation(Integer code){
        if (code == null) {
            List<Kelurahan> kelurahan = kelurahanRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", kelurahan);
            return responseData;
        } else {
            Kelurahan kelurahanOpt = kelurahanRepo.findByCodeKel(code);
            if (kelurahanOpt != null) {
                Kelurahan kelurahan = kelurahanOpt;
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", kelurahan);
                return responseData;
            } else {
                throw new DataNotFoundException("Data provinsi tidak ditemukan!");
            }
        }
    }

    public ResponseData<Object> updateKelValidation(Kelurahan kelurahanOpt,KelurahanDto kelurahanDto) {
        if (kelurahanOpt != null) {
            Kelurahan kelurahan = kelurahanOpt;
            kelurahan.setCodeKel(kelurahanDto.getKodeKelurahan());
            kelurahan.setKelurahan(kelurahanDto.getKelurahan());
            kelurahanRepo.save(kelurahan);
            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "data berhasil diupdate", kelurahan);
            return responseData;
        } else {
            throw new DataNotFoundException("data kecamatan tidak ditemukan");
        }
    }

    public ResponseData<Object> deleteKelValidation(Kelurahan kelurahanOpt) {
        if (kelurahanOpt != null) {
            Kelurahan kelurahan = kelurahanOpt;
            kelurahan.setIsDeleted(true);
            kelurahanRepo.save(kelurahan);
            responseData = new ResponseData<Object>(HttpStatus.ACCEPTED.value(), "data berhasil dihapus", null);
            return responseData;
        } else {
            throw new DataNotFoundException("data kecamatan tidak ditemukan");
        }
    }
}

