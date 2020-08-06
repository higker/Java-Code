package com.dicitek.cms.mapper;


import com.dicitek.cms.model.product;
import org.apache.ibatis.annotations.*;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface productService {

    @Select("SELECT *  FROM  sys_product")
    public List<product> getAll();

    @Delete("DELETE FROM sys_product  WHERE id = #{id} ")
    public int delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO sys_product (name,img_url) VALUES (#{name},#{imgUrl})")
    public boolean insert(@Param("name") String name,
                              @Param("imgUrl") String imgUrl);
}
