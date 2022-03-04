package com.softtech.softtechspringboot.cmt.service.entityservice;

import com.softtech.softtechspringboot.cmt.dao.CmtCommentDao;
import com.softtech.softtechspringboot.cmt.entity.CmtComment;
import com.softtech.softtechspringboot.cmt.enums.CmtErrorMessage;
import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CmtCommentEntityService extends BaseEntityService<CmtComment, CmtCommentDao> {

    private final CmtCommentDao cmtCommentDao;

    public CmtCommentEntityService(CmtCommentDao cmtCommentDao) {
        super(cmtCommentDao);
        this.cmtCommentDao = cmtCommentDao;
    }

    public CmtComment getByUserIdWithControl(Long userId) {

        return checkIfCommentExistsByUserId(userId);

    }

    private CmtComment checkIfCommentExistsByUserId(Long userId) {

        CmtComment cmtComment = cmtCommentDao.findByUserId(userId)
                .orElseThrow(() -> new ItemNotFoundException(CmtErrorMessage.USER_HAS_NO_COMMENT));


        return cmtComment;
    }


    public List<CmtComment> getAllByProductId(Long productId) {

        List<CmtComment> cmtCommentList = cmtCommentDao.findAllByProductId(productId)
                .orElseThrow(()-> new ItemNotFoundException(CmtErrorMessage.PRODUCT_HAS_NO_COMMENT));

        return cmtCommentList;

    }

    public CmtComment save(CmtComment cmtComment) {
        cmtCommentDao.save(cmtComment);
        return cmtComment;
    }

    public void delete(Long id){

        CmtComment cmtComment = checkIfCommentExistsById(id);
        cmtCommentDao.delete(cmtComment);

    }

    private CmtComment checkIfCommentExistsById(Long id){

        CmtComment cmtComment = cmtCommentDao.findById(id)
                .orElseThrow(()-> new ItemNotFoundException(CmtErrorMessage.COMMENT_NOT_FOUND));

        return cmtComment;

    }

}
