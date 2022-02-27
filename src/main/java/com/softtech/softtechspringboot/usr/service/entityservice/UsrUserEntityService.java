package com.softtech.softtechspringboot.usr.service.entityservice;


import com.softtech.softtechspringboot.gen.exceptions.ItemAlreadyExistsException;
import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.exceptions.UnmatchedFieldsException;
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

        UsrUser usrUser = checkIfUserExistsByUsername(username);
        return usrUser;

    }

    private UsrUser checkIfUserExistsByUsername(String username){

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

        checkIfUsernameAlreadyExists(usrUser);
        checkIfEmailAlreadyExists(usrUser);
        checkIfPhoneNumberAlreadyExists(usrUser);

        usrUserDao.save(usrUser);

        return usrUser;

    }
    /*
    *  I am well aware that following three methods are same, but I could not get generalized
    *  them because of the method usage.
    */

    private void checkIfUsernameAlreadyExists(UsrUser usrUser){

        Optional<UsrUser> usernameMatches = usrUserDao.findByUsername(usrUser.getUsername());
        if(usernameMatches.isPresent()){
            boolean isItItself= usernameMatches.get().getId().equals(usrUser.getId());
            if(!isItItself){
                throw new ItemAlreadyExistsException(UsrErrorMessage.USERNAME_ALREADY_EXISTS);
            }
        }

    }

    private void checkIfEmailAlreadyExists(UsrUser usrUser){

        Optional<UsrUser> emailMatches = usrUserDao.findByEmail(usrUser.getEmail());

        if(emailMatches.isPresent()){
            boolean isItItself= emailMatches.get().getEmail().equals(usrUser.getEmail());
            if(!isItItself){
                throw new ItemAlreadyExistsException(UsrErrorMessage.EMAIL_ALREADY_EXISTS);
            }
        }
    }

    private void checkIfPhoneNumberAlreadyExists(UsrUser usrUser){

        Optional<UsrUser> phoneNumberMatches = usrUserDao.findByPhoneNumber(usrUser.getPhoneNumber());

        if(phoneNumberMatches.isPresent()){
            boolean isItItself = phoneNumberMatches.get().getPhoneNumber().equals(usrUser.getPhoneNumber());
            if(!isItItself){
                throw new ItemAlreadyExistsException(UsrErrorMessage.PHONE_NUMBER_ALREADY_EXISTS);
            }

        }

    }

    public UsrUser update(UsrUser usrUser) {

        checkIfUserExistById(usrUser);
        saveWithControl(usrUser);
        return usrUser;
    }

    private void checkIfUserExistById(UsrUser usrUser) {

        Long id = usrUser.getId();
        boolean isExist = usrUserDao.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(UsrErrorMessage.USER_NOT_FOUND);
        }
    }

    public void deleteWithControl(String username, String phoneNumber){

        UsrUser usrUser = checkIfUsernameAndPhoneNumberMatch(username,phoneNumber);

        super.delete(usrUser);

    }

    private UsrUser checkIfUsernameAndPhoneNumberMatch(String username, String phoneNumber){

        UsrUser usrUser = checkIfUserExistsByUsername(username);

        if(!usrUser.getPhoneNumber().equals(phoneNumber)){
            throw new UnmatchedFieldsException(UsrErrorMessage.UNMATCHED_EMAIL_AND_PHONE_NUMBER);
        }
        return usrUser;
    }


}
