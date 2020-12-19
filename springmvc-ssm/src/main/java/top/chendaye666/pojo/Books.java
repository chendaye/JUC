package top.chendaye666.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 映射数据库的表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor // 添加构造器
public class  Books {
    private int book_id;
    private String book_name;
}
