package Api.tugas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Api.tugas.dto.ResponseData;
import Api.tugas.dto.request.KabKotDto;
import Api.tugas.service.KabKotService;

@RestController
@RequestMapping("/kabupatenKota")
public class KabKotController {
    @Autowired
    private KabKotService kabKotService;

    private ResponseData<Object> responseData;

    @PostMapping
    public ResponseEntity<Object> createKabKot(@RequestBody KabKotDto kabKotDto) {
        responseData = kabKotService.createKab(kabKotDto);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping
    public ResponseEntity<Object> getkabKot(@RequestParam(value = "code", defaultValue ="")Integer code) {
        responseData = kabKotService.getAllKab(code);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }


}
