package com.softtech.softtechspringboot.usr.entity;

import com.softtech.softtechspringboot.gen.entity.BaseEntity;
import com.softtech.softtechspringboot.usr.enums.UsrUserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="USR_USER")
@Data
public class UsrUser extends BaseEntity {
    @Id
    @SequenceGenerator(name ="UsrUser" ,sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name="USERNAME",length=30)
    private String username;

    @Column(name="EMAIL",length=30,unique = true)
    private String email;

    @Column(name="PHONE_NUMBER",length=15,unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="USER_TYPE",length=30)
    private UsrUserType userType;
}
