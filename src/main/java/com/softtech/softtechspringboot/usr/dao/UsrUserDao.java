package com.softtech.softtechspringboot.usr.dao;

import com.softtech.softtechspringboot.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrUserDao extends JpaRepository<UsrUser,Long> {

}
