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

import Api.tugas.dto.ProvinsiDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.model.Provinsi;
import Api.tugas.service.ProvService;

@RestController
@RequestMapping("/provinsi")
public class ProvController {
    @Autowired
    private ProvService provService;

    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<?> getProv(@RequestParam(value = "code", defaultValue = "") Provinsi code) {
        responseData = provService.getAllProv(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PostMapping
    public ResponseEntity<?> createProv(@RequestBody ProvinsiDto provinsiDto) {
        responseData = provService.createProv(provinsiDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateProv(@PathVariable Provinsi code, @RequestBody ProvinsiDto provinsiDto) {
        responseData = provService.updateProv(code, provinsiDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteProv(@PathVariable Provinsi code) {
        responseData = provService.deletePRov(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
