package com.softtech.softtechspringboot.cmt.controller;

import com.softtech.softtechspringboot.cmt.dto.CmtCommentDto;
import com.softtech.softtechspringboot.cmt.service.CmtCommentService;
import com.softtech.softtechspringboot.gen.dto.RestResponse;
import com.softtech.softtechspringboot.usr.dto.UsrUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CmtCommentController {
    private final CmtCommentService cmtCommentService;

    @GetMapping("/user-id/{userId}")
    public ResponseEntity findByUserId(@PathVariable Long userId){

        CmtCommentDto cmtCommentDto = cmtCommentService.findByUserId(userId);
        return ResponseEntity.ok(RestResponse.of(cmtCommentDto));

    }

    @GetMapping("/product-id/{productId}")
    public ResponseEntity findAllByProductId(@PathVariable Long productId){

        List<CmtCommentDto> cmtCommentDtoList = cmtCommentService.findAllByProductId(productId);
        return ResponseEntity.ok(RestResponse.of(cmtCommentDtoList));

    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CmtCommentDto cmtCommentDto){

        CmtCommentDto cmtCommentDtoSaved = cmtCommentService.save(cmtCommentDto);
        return ResponseEntity.ok(RestResponse.of(cmtCommentDtoSaved));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        cmtCommentService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());

    }

}
