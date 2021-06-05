package top.chendaye666.springbootwxmeet.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 表的映射
 * getter setter 很烦，可以用 lombok + lombok -plugin
 */
@Entity
@DynamicUpdate // 自动更新时间
@Data // lombok 自动生成 GET SET toString
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }



    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


}
