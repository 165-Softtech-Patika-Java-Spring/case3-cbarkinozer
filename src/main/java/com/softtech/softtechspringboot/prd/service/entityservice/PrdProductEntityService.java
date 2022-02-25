package com.softtech.softtechspringboot.prd.service.entityservice;

import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import com.softtech.softtechspringboot.prd.dao.PrdProductDao;
import com.softtech.softtechspringboot.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {
    public PrdProductEntityService(PrdProductDao prdProductDao){
        super(prdProductDao);
    }

}
