package Api.tugas.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.KabupatenKota;
import Api.tugas.repository.KabKotRepo;


@Service
public class KabKotValidator {
    ResponseData<Object> responseData;
    
    

    @Autowired
    KabKotRepo kabKotRepo;

    public ResponseData<Object> getKabKotValidation(Integer code) {
        if (code == null) {
            List<KabupatenKota> kabKot = kabKotRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "Success", kabKot);
            return responseData;
        } else {
            KabupatenKota kabKotOpt = kabKotRepo.findByKabKotCode(code);
            if (kabKotOpt != null ) {
                KabupatenKota kabKot = kabKotOpt;
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "Success",kabKot );
                return responseData;
            } else {
                throw new DataNotFoundException("Data Kabupaten tidak ditemukan");
            }
        }
    }
}
