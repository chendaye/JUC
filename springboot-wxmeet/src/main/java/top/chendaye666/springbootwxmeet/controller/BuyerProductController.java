package top.chendaye666.springbootwxmeet.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;
import top.chendaye666.springbootwxmeet.service.ProductInfoService;
import top.chendaye666.springbootwxmeet.service.impl.ProductCategoryServiceImpl;
import top.chendaye666.springbootwxmeet.service.impl.ProductInfoServiceImpl;
import top.chendaye666.springbootwxmeet.vo.ProductInfoVo;
import top.chendaye666.springbootwxmeet.vo.ProductVo;
import top.chendaye666.springbootwxmeet.vo.ResultVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController // 接口
@RequestMapping("/buyer/product/")
public class BuyerProductController {

    @Autowired
    ProductInfoServiceImpl productInfoService;
    @Autowired
    ProductCategoryServiceImpl categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        // 查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 查询类目
        List<Integer> integerList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(integerList);

        // 组装数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo); // 复制对象属性
                    productInfoVoList.add(productInfoVo);
                }
            }
//            productVo.setProductInfoVosVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        ResultVo<List<ProductVo>> resp = ResultVo.createBySuccess("成功", productVoList);
        return resp;
    }
}
