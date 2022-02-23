package com.softtech.softtechspringboot.usr.dto;

import com.softtech.softtechspringboot.usr.enums.UsrUserType;
import lombok.Data;


@Data
public class UsrUserDto {
    private String username;
    private String email;
    private String phoneNumber;
    private UsrUserType userType;
}
