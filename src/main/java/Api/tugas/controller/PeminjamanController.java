package Api.tugas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.tugas.dto.PeminjamanDto;
import Api.tugas.dto.ResponseData;
import Api.tugas.service.PeminjamanService;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    ResponseData<Object> responseData;
    @Autowired
    PeminjamanService peminjamanService;
    
    @PostMapping
    public ResponseEntity<Object> addPeminjaman(@RequestBody PeminjamanDto peminjamanDto){
        responseData = peminjamanService.addPeminjaman(peminjamanDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> endPeminjaman(@PathVariable Integer id){
        responseData = peminjamanService.endPeminjaman(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
