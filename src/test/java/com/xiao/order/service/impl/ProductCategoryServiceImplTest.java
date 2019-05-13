package com.xiao.order.service.impl;

import com.xiao.order.model.ProductCategory;
import com.xiao.order.service.ProductCategoryService;
import com.xiao.order.vo.PagerVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XiaoPengCheng
 * @create 2019-04-30 14:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void listPage() {
        PagerVo pagerVo = new PagerVo();
        pagerVo.setPage(2);
        pagerVo.setLimit(1);
        PagerVo pagerVo_result = productCategoryService.listPage(pagerVo);
        System.out.println("listPage的返回值: "+ pagerVo_result);
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(4);
        productCategory.setCategoryName("小吃类");
        boolean save = productCategoryService.save(productCategory);
        System.out.println("保存状态：" + save);
    }
}