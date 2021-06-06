package top.chendaye666.springbootwxmeet.form;

import lombok.Data;

/**
 * 用于表单验证
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
