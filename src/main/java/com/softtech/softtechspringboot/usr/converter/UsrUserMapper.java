package com.softtech.softtechspringboot.usr.converter;

import com.softtech.softtechspringboot.cmt.converter.CmtCommentMapper;
import com.softtech.softtechspringboot.cmt.dto.CmtCommentDto;
import com.softtech.softtechspringboot.cmt.entity.CmtComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


public interface UsrUserMapper {

    CmtCommentMapper INSTANCE = Mappers.getMapper(CmtCommentMapper.class);

    CmtComment convertToAddAddress(CmtCommentDto cmtCommentDto);
    List<CmtCommentDto> convertToAddAddressDtoList(List<CmtComment> cmtCommentList);
    CmtCommentDto convertToAddAddressDto(CmtComment cmtComment);
}
