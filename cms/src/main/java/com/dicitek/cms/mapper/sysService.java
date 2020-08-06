package com.dicitek.cms.mapper;

import com.dicitek.cms.model.sysInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface sysService {

    @Select("SELECT *  FROM  sys_info")
    public sysInfo getInfo();
}
