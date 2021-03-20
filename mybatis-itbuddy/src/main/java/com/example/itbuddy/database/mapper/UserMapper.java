package com.example.itbuddy.database.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    public slectUserByUserKey(@Param("userKey") String userKey);
}
