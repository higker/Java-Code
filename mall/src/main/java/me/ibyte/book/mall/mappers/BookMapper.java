package me.ibyte.book.mall.mappers;

import me.ibyte.book.mall.models.Book;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT *  FROM  books")
    public List<Book> getAll();

    @Select("SELECT * FROM books WHERE id = #{id}")
    public Book getBookById(@Param("id") Long id);

    @Select("SELECT * FROM books WHERE book_name LIKE '%${Key}%'")
    public List<Book> findBookByKey(@Param("Key") String key);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO books (author,introduction,money,number,book_name,pic_url,create_time) VALUES (#{author},#{introduction},#{money},#{number},#{book_name},#{PicUrl} ,#{createTime})")
    public boolean insertUser(@Param("author") String author,
                              @Param("introduction") String introduction,
                              @Param("money") BigDecimal money,
                              @Param("number") int number,
                              @Param("book_name") String book_name,
                              @Param("PicUrl") String PicUrl,
                              @Param("createTime") Timestamp createTime);
}
