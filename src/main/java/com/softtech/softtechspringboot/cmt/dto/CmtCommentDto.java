package com.softtech.softtechspringboot.cmt.dto;

import lombok.Data;


@Data
public class CmtCommentDto {

    private String comment;
    private Long productId;
    private Long userId;
}
