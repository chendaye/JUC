package top.chendaye666.dao;

import org.apache.ibatis.annotations.Param;
import top.chendaye666.pojo.Books;

public interface BooksMapper {
    public void add(Books books);

    public void delete(@Param("book_id") int id);
}
