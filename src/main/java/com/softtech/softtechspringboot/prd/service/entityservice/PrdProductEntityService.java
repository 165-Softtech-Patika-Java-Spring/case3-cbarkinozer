package com.softtech.softtechspringboot.prd.service.entityservice;

import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import com.softtech.softtechspringboot.prd.dao.PrdProductDao;
import com.softtech.softtechspringboot.prd.dto.PrdProductDto;
import com.softtech.softtechspringboot.prd.entity.PrdProduct;
import com.softtech.softtechspringboot.prd.enums.PrdErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    private final PrdProductDao prdProductDao;

    @Autowired
    public PrdProductEntityService(PrdProductDao prdProductDao){
        super(prdProductDao);
        this.prdProductDao = prdProductDao;
    }

    public PrdProduct updatePrice(Long id, BigDecimal price) {

        Optional<PrdProduct> productOptional = prdProductDao.findById(id);

        PrdProduct prdProduct;

        if (productOptional.isPresent()){
            prdProduct = productOptional.get();
        } else {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_ERROR_MESSAGE);
        }

        prdProduct.setPrice(price);
        return prdProductDao.save(prdProduct);
    }
}
