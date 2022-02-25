package com.softtech.softtechspringboot.prd.controller;

import com.softtech.softtechspringboot.prd.dto.PrdProductDto;
import com.softtech.softtechspringboot.prd.service.PrdProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class PrdProductController {

    private final PrdProductService prdProductService;

    @GetMapping
    public ResponseEntity findAll(){
        List<PrdProductDto> prdProductDtoList = prdProductService.findAll();
        return ResponseEntity.ok(prdProductDtoList);
    }
    

    @PostMapping
    public ResponseEntity save(@RequestBody PrdProductDto prdProductDto){
        PrdProductDto prdProductDtoSaved = prdProductService.save(prdProductDto);
        return ResponseEntity.ok(prdProductDtoSaved);
    }

}
