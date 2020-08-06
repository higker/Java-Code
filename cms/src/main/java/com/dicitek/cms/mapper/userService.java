package com.dicitek.cms.mapper;


import com.dicitek.cms.model.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userService {


    @Select("SELECT *  FROM  sys_users  WHERE  username = #{username}  and password = #{password}")
    public user login(String username, String password);
}
