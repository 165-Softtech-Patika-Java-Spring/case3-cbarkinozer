package com.softtech.softtechspringboot.cmt.service.entityservice;

import com.softtech.softtechspringboot.cmt.dao.CmtCommentDao;
import com.softtech.softtechspringboot.cmt.entity.CmtComment;
import com.softtech.softtechspringboot.cmt.enums.CmtErrorMessage;
import com.softtech.softtechspringboot.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.gen.service.BaseEntityService;
import com.softtech.softtechspringboot.usr.entity.UsrUser;
import com.softtech.softtechspringboot.usr.enums.UsrErrorMessage;
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

        CmtComment cmtComment = checkIfCommentExistsByUserId(userId);
        return cmtComment;

    }

    private CmtComment checkIfCommentExistsByUserId(Long userId) {

        Optional<CmtComment> commentOptional = cmtCommentDao.findByUserId(userId);

        CmtComment cmtComment;
        if (commentOptional.isPresent()){
            cmtComment = commentOptional.get();
        } else {
            throw new ItemNotFoundException(CmtErrorMessage.USER_HAS_NO_COMMENT);
        }
        return cmtComment;
    }


    public List<CmtComment> getAllByProductId(Long productId) {

        Optional<CmtComment> commentOptional = cmtCommentDao.findAllByProductId(productId);

        List<CmtComment> cmtCommentList;
        if (commentOptional.isPresent()){
            cmtCommentList= commentOptional.stream().toList();
        } else {
            throw new ItemNotFoundException(CmtErrorMessage.PRODUCT_HAS_NO_COMMENT);
        }
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

        Optional<CmtComment> commentOptional = cmtCommentDao.findById(id);

        CmtComment cmtComment;
        if (commentOptional.isPresent()){
            cmtComment = commentOptional.get();
        } else {
            throw new ItemNotFoundException(CmtErrorMessage.COMMENT_NOT_FOUND);
        }

        return cmtComment;

    }

}
