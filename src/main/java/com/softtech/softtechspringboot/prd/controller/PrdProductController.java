package com.softtech.softtechspringboot.prd.controller;

import com.softtech.softtechspringboot.prd.dto.PrdProductDto;
import com.softtech.softtechspringboot.prd.entity.PrdProduct;
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
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        PrdProductDto prdProductDto = prdProductService.findById(id);
        return ResponseEntity.ok(prdProductDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody PrdProductDto prdProductDto){
        PrdProductDto prdProductDtoSaved = prdProductService.save(prdProductDto);
        return ResponseEntity.ok(prdProductDtoSaved);
    }

}
