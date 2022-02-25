package com.softtech.softtechspringboot.prd.service;


import com.softtech.softtechspringboot.prd.converter.PrdProductMapper;
import com.softtech.softtechspringboot.prd.dto.PrdProductDto;
import com.softtech.softtechspringboot.prd.entity.PrdProduct;
import com.softtech.softtechspringboot.prd.service.entityservice.PrdProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrdProductService {
    private final PrdProductEntityService prdProductEntityService;

    public PrdProductDto save(PrdProductDto prdProductDto){
        PrdProduct prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductDto);
        prdProduct = prdProductEntityService.save(prdProduct);
        return PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);
    }

}
