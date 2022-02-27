package com.softtech.softtechspringboot.cmt.dao;

import com.softtech.softtechspringboot.cmt.entity.CmtComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CmtCommentDao extends JpaRepository<CmtComment,Long> {

    Optional<CmtComment> findByUserId(Long userId);
    Optional<CmtComment> findAllByProductId(Long productId);

}
