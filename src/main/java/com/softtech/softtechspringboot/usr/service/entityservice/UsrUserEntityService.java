package com.softtech.softtechspringboot.usr.service.entityservice;

import com.softtech.softtechspringboot.gen.enums.GenErrorMessage;
import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import com.softtech.softtechspringboot.usr.dao.UsrUserDao;
import com.softtech.softtechspringboot.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    private final UsrUserDao usrUserDao;

    public UsrUserEntityService(UsrUserDao usrUserDao) {

        super(usrUserDao);
        this.usrUserDao=usrUserDao;
    }

    public UsrUser getByUsernameWithControl(String username) {

        Optional<UsrUser> userOptional = usrUserDao.findByUsername(username);

        UsrUser usrUser;
        if (userOptional.isPresent()){
            usrUser = userOptional.get();
        } else {
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }

        return usrUser;

    }
}
