package me.ibyte.book.mall.mappers;


import me.ibyte.book.mall.models.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {


    @Select("SELECT * FROM Admin WHERE account = #{Account} AND password = #{Password} ")
    Admin findUser(Admin admin);

}
