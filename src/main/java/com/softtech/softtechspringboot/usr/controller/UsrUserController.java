package com.softtech.softtechspringboot.usr.controller;

import com.softtech.softtechspringboot.gen.dto.RestResponse;
import com.softtech.softtechspringboot.usr.dto.UsrUserDto;
import com.softtech.softtechspringboot.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsrUserController {

    private final UsrUserService usrUserService;

    @GetMapping
    public ResponseEntity findAll(){
        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();
        return ResponseEntity.ok(RestResponse.of(usrUserDtoList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        UsrUserDto usrUserDto = usrUserService.findById(id);
        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity findByUsername(@PathVariable String username){
        UsrUserDto usrUserDto = usrUserService.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UsrUserDto usrUserDto){
        UsrUserDto usrUserDtoSaved = usrUserService.save(usrUserDto);
        return ResponseEntity.ok(RestResponse.of(usrUserDtoSaved));
    }

}
