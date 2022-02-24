package com.softtech.softtechspringboot.cmt.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="CMT_COMMENT")
@Data
public class CmtComment {

    @Id
    @SequenceGenerator(name ="CMT_COMMENT" ,sequenceName = "CMT_COMMENT_ID_SEQ")
    @GeneratedValue(generator ="CMT_COMMENT")
    private Long id;

    @Lob
    @Column(name="COMMENT")
    private String comment;

    @Column(name="ID_PRD_PRODUCT")
    private Long productId;

    @Column(name="ID_USR_USER")
    private Long userId;
}
