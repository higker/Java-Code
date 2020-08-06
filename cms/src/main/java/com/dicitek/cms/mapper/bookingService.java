package com.dicitek.cms.mapper;

import com.dicitek.cms.model.booking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface bookingService {

    @Select("SELECT *  FROM  sys_booking")
    public List<booking> getAll();

    @Delete("DELETE FROM sys_booking WHERE id = #{id} ")
    public int delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO sys_booking (phone,message) VALUES (#{phone},#{message})")
    public boolean insert(@Param("phone") String phone,
                          @Param("message") String message);
}
