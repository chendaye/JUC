package top.chendaye666.mall.service;

import top.chendaye666.mall.common.ServerResponse;
import top.chendaye666.mall.pojo.Category;

import java.util.List;


public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
