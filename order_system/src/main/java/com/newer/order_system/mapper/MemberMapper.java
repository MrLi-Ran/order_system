package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    // 根据电话查找是否有该会员
    Member findByTelPhone(@Param("telPhone") String telPhone);
}
