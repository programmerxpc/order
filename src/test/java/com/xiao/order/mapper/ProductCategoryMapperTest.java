package com.xiao.order.mapper;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.xiao.order.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @SuppressWarnings("all")
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void save() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("热销榜");

        int row = productCategoryMapper.save(productCategory);
        System.out.println("受影响行数：" + row);

    }

    @Test
    public void updateById(){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1);
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("热销榜");

        int row = productCategoryMapper.updateById(productCategory);
        System.out.println("影响行数：" + row);

    }

    @Test
    public void list(){

        List<ProductCategory> list = productCategoryMapper.list();
        System.out.println("记录：" + list);

    }

    @Test
    public void listPage(){

        List<ProductCategory> productCategoryList = productCategoryMapper.listPage(1, 1);
        System.out.println("记录：" + productCategoryList);

    }

    @Test
    public void getByCategoryId(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        ProductCategory category = productCategoryMapper.getByCategoryId(productCategory);
        System.out.println("商品类别：" + category);
    }

    @Test
    public void getByCategoryName(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("冷饮类");
        ProductCategory category = productCategoryMapper.getByCategoryName(productCategory);
        System.out.println("商品类别：" + category);
    }

    @Test
    public void listByCategoryNamePage(){

        List<ProductCategory> productCategoryList = productCategoryMapper.listByCategoryNamePage("热销榜",0,2);
        System.out.println("商品类别：" + productCategoryList);
    }

    @Test
    public void getCountByCategoryName(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("冷饮类");
        int total = productCategoryMapper.getCountByCategoryName(productCategory);
        System.out.println("总数：" + total);
    }

    @Test
    public void removeByIdList(){
        ArrayList<ProductCategory> list = new ArrayList<>();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(5);
        list.add(productCategory);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setId(6);
        list.add(productCategory2);

        int row = productCategoryMapper.removeByIdList(list);
        System.out.println("影响行数："+row);
    }
}