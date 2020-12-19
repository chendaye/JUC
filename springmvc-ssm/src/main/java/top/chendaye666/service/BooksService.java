package top.chendaye666.service;

import org.apache.ibatis.annotations.Param;
import top.chendaye666.pojo.Books;

public interface BooksService {
    public void add(Books books);

    public void delete(int id);
}
