package Api.tugas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Api.tugas.dto.KelurahanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.service.KelurahanService;

@RestController
@RequestMapping("/kelurahan")
public class KelController {
    ResponseData<Object> responseData;

    @Autowired
    KelurahanService kelurahanService;

    @PostMapping
    public ResponseEntity<Object> createKelurahan(@RequestBody KelurahanDto kelurahanDto) {
        responseData = kelurahanService.createKelurahan(kelurahanDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping
    public ResponseEntity<Object> getKelurahan(@RequestParam(value = "code", defaultValue = "")Integer code) {
        responseData = kelurahanService.getKelurahan(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateKelurahan(@PathVariable Integer code, @RequestBody KelurahanDto kelurahanDto){
        responseData = kelurahanService.updateKelurahan(code, kelurahanDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteKelurahan(@PathVariable Integer code){
        responseData = kelurahanService.deleteKelurahan(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}   
