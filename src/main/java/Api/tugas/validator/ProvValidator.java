package Api.tugas.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.ProvinsiDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Provinsi;
import Api.tugas.repository.ProvinsiRepo;

@Service
public class ProvValidator {
    private ResponseData<Object> responseData;
    @Autowired
    ProvinsiRepo provinsiRepo;

    public ResponseData<Object> getProvValidation(Integer code) {
        if (code == null) {
            List<Provinsi> provinsi = provinsiRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", provinsi);
            return responseData;
        } else {
            Provinsi provinsiOpt = provinsiRepo.findByprovCode(code);
            if (provinsiOpt != null) {
                Provinsi provinsi = provinsiOpt;
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", provinsi);
                return responseData;
            } else {
                throw new DataNotFoundException("Data provinsi tidak ditemukan!");
            }
        }
    }

    public ResponseData<Object> updateProvValidation(Provinsi provinsiOpt, ProvinsiDto provinsiDto) {
        if (provinsiOpt != null) {
            Provinsi provinsi = provinsiOpt;
            provinsi.setProvCode(provinsiDto.getKodeProvinsi());
            provinsi.setProvinsi(provinsiDto.getProvinsi());
            provinsiRepo.save(provinsi);
            responseData = new ResponseData<Object>(HttpStatus.ACCEPTED.value(), "Data berhasil diupdate", provinsi);
            return responseData;
        } else {
            throw new DataNotFoundException("Data Provinsi tidak ditemukan");
        }
    }

    public ResponseData<Object> deleteProvValidation(Provinsi provinsiOpt) {
        if (provinsiOpt != null) {
            Provinsi provinsi = provinsiOpt;
            provinsi.setIsDeleted(true);
            provinsiRepo.save(provinsi);
            String message = provinsi.getProvinsi() + " berhasil dihapus";
            responseData = new ResponseData<Object>(HttpStatus.ACCEPTED.value(), message, null);
            return responseData;
        } else {
            throw new DataNotFoundException("Data provinsi tidak ditemukan!");
        }
    }
}
