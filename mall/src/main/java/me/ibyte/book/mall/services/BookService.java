package me.ibyte.book.mall.services;


import me.ibyte.book.mall.mappers.BookMapper;
import me.ibyte.book.mall.models.Book;
import me.ibyte.book.mall.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * books 服务层
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public List<Book> allBook() {
        return bookMapper.getAll();
    }

    public List<Book> searchBook(String key) {
        return bookMapper.findBookByKey(key);
    }



    public boolean saveBook(Book bk) {
        bk.setCreateTime(TimeUtil.asDateToTimestamp());
        bk.setPicUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1017284221,1311934858&fm=15&gp=0.jpg");
        return bookMapper.insertUser(bk.getAuthor(),bk.getIntroduction(),bk.getMoney(),bk.getNumber(),bk.getBookName(),bk.getPicUrl(),bk.getCreateTime());
    }

    public Book detailedBook(String id){
        return bookMapper.getBookById(Long.parseLong(id));
    }

}
