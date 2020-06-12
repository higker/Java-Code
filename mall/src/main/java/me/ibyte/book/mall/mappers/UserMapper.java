package me.ibyte.book.mall.mappers;


import me.ibyte.book.mall.models.User;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @Insert("INSERT INTO users (email,password,create_time) VALUES (#{email},#{password},#{createTime})")
    public boolean insertUser(@Param("email") String username,
                              @Param("password") String password,
                              @Param("createTime") Timestamp createTime);
    @Select("SELECT * FROM users WHERE email = #{Email} AND password = #{Password} ")
    User findUser(User user);

    @Select("SELECT * FROM users WHERE  id = #{id} ")
    User getUser(@Param("id") String id);

    @Update("UPDATE users SET surplus = (surplus - #{total})   WHERE id = #{id} ")
    int updatedMoney(@Param("total") BigDecimal total, @Param("id") Long id);
}
