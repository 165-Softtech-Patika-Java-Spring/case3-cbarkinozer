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
            throw new ItemNotFoundException(UsrErrorMessage.USER_NOT_FOUND);
        }

        return usrUser;

    }

    public UsrUser saveWithControl(UsrUser usrUser){

        checkIsUsernameDuplicate(usrUser);
        checkIsEmailDuplicate(usrUser);
        checkIsPhoneNumberDuplicate(usrUser);

        super.save(usrUser);

        return usrUser;

    }

    private void checkIsUsernameDuplicate(UsrUser usrUser){

        Optional<UsrUser> usernameMatches = usrUserDao.findByUsername(usrUser.getUsername());

        if(usernameMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.USERNAME_EXISTS);
        }

    }

    private void checkIsEmailDuplicate(UsrUser usrUser){

        Optional<UsrUser> emailMatches = usrUserDao.findByEmail(usrUser.getEmail());

        if(emailMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.EMAIL_EXISTS);
        }

    }

    private void checkIsPhoneNumberDuplicate(UsrUser usrUser){

        Optional<UsrUser> phoneNumberMatches = usrUserDao.findByPhoneNumber(usrUser.getPhoneNumber());

        if(phoneNumberMatches.isPresent()){
            throw new ItemAlreadyExistsException(UsrErrorMessage.PHONE_NUMBER_EXISTS);
        }

    }

    public UsrUser update(UsrUser usrUser) {

        checkIsUserExist(usrUser);
        saveWithControl(usrUser);
        return usrUser;
    }

    private void checkIsUserExist(UsrUser usrUser) {

        Long id = usrUser.getId();
        boolean isExist = super.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(UsrErrorMessage.USER_NOT_FOUND);
        }
    }

}
