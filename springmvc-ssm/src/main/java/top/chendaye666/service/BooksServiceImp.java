package top.chendaye666.service;

import org.springframework.stereotype.Service;
import top.chendaye666.dao.BooksMapper;
import top.chendaye666.pojo.Books;

/**
 * 业务层 service 调用 dao 层
 */
@Service
public class BooksServiceImp implements BooksService {

    //组合 BooksMapper
    private BooksMapper booksMapper;

    // spring 通过 setter 注入
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public void add(Books books) {
        booksMapper.add(books);
    }

    @Override
    public void delete(int id) {
        booksMapper.delete(id);
    }
}
