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

import Api.tugas.dto.KecamatanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.service.KecamatanService;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanContr {
    @Autowired
    KecamatanService kecamatanService;

    ResponseData<Object> responseData;

    @PostMapping
    public ResponseEntity<Object> createKecamatan(@RequestBody KecamatanDto kecamatanDto) {
        responseData = kecamatanService.createKec(kecamatanDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);

    }

    @GetMapping
    public ResponseEntity<Object> getKecamatan(@RequestParam(value = "code", defaultValue = "") Integer code) {
        responseData = kecamatanService.getAllKec(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateKecamatan(@PathVariable Integer code, @RequestBody KecamatanDto kecamatanDto){
        responseData = kecamatanService.updateKec(code, kecamatanDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteKecamatan(@PathVariable Integer code) {
        responseData = kecamatanService.deleteKec(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
