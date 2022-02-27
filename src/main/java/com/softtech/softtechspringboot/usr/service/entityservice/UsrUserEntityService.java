package com.softtech.softtechspringboot.usr.service.entityservice;


import com.softtech.softtechspringboot.gen.exceptions.ItemAlreadyExistsException;
import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import com.softtech.softtechspringboot.usr.dao.UsrUserDao;
import com.softtech.softtechspringboot.usr.entity.UsrUser;
import com.softtech.softtechspringboot.usr.enums.UsrErrorMessage;
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
            throw new ItemNotFoundException(UsrErrorMessage.USER_ERROR_MESSAGE);
        }

        return usrUser;

    }

    public UsrUser saveWithControl(UsrUser usrUser){

        checkUsername(usrUser);
        checkEmail(usrUser);
        checkPhoneNumber(usrUser);

        super.save(usrUser);

        return usrUser;

    }

    private void checkUsername(UsrUser usrUser){

        Optional<UsrUser> usernameMatches = usrUserDao.findByUsername(usrUser.getUsername());

        if(usernameMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.USERNAME_EXISTS);
        }

    }

    private void checkEmail(UsrUser usrUser){

        Optional<UsrUser> emailMatches = usrUserDao.findByEmail(usrUser.getEmail());

        if(emailMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.EMAIL_EXISTS);
        }

    }

    private void checkPhoneNumber(UsrUser usrUser){

        Optional<UsrUser> phoneNumberMatches = usrUserDao.findByPhoneNumber(usrUser.getPhoneNumber());

        if(phoneNumberMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.PHONE_NUMBER_EXISTS);
        }

    }



}
