package com.xiao.order.service.impl;

import com.xiao.order.mapper.ProductCategoryMapper;
import com.xiao.order.model.ProductCategory;
import com.xiao.order.service.ProductCategoryService;
import com.xiao.order.vo.PagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-28 10:38
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @SuppressWarnings("all")
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> list = productCategoryMapper.list();
        if (list != null && list.size() > 0){
            //商品类别存在
            return list;
        }else {
            return null;
        }
    }

    @Override
    public PagerVo listPage(PagerVo pagerVo) {
        int page = pagerVo.getPage();//当前页
        int limit = pagerVo.getLimit();//每页显示的记录数
        int total = productCategoryMapper.getCount();//获取商品类别总数

        if (page == 1){//数据表格默认传入page=1
            page = 0;
            List<ProductCategory> productCategoryList = productCategoryMapper.listPage(page, limit);
            if (productCategoryList == null || productCategoryList.size() == 0){
                //商品类别不存在
                return null;
            }
            pagerVo.setData(productCategoryList);
            pagerVo.setTotal(total);
            return pagerVo;

        }else {
            page = (page - 1)*limit;
            List<ProductCategory> productCategoryList = productCategoryMapper.listPage(page, limit);
            if (productCategoryList == null || productCategoryList.size() == 0){
                return null;
            }
            pagerVo.setData(productCategoryList);
            pagerVo.setTotal(total);
            return pagerVo;
        }
    }

    @Override
    public PagerVo listByCategoryNamePage(PagerVo pagerVo) {
        PagerVo<Object> pagerVo_result = new PagerVo<>();

        int page = pagerVo.getPage();//当前页
        int limit = pagerVo.getLimit();//每页显示的记录数
        ProductCategory productCategory = (ProductCategory) pagerVo.getData();
        String categoryName = productCategory.getCategoryName();//获取商品类名
        int total = productCategoryMapper.getCountByCategoryName(productCategory);//根据商品类名获取商品类别总数

        if (page == 1){//数据表格默认传入page=1
            page = 0;
            List<ProductCategory> productCategoryList = productCategoryMapper.listByCategoryNamePage(categoryName, page, limit);
            if (productCategoryList == null || productCategoryList.size() == 0){
                //商品类别不存在
                return null;
            }
            pagerVo_result.setData(productCategoryList);
            pagerVo_result.setTotal(total);
            return pagerVo_result;

        }else {
            page = (page - 1)*limit;
            List<ProductCategory> productCategoryList = productCategoryMapper.listByCategoryNamePage(categoryName, page, limit);
            if (productCategoryList == null || productCategoryList.size() == 0){
                //商品类别不存在
                return null;
            }
            pagerVo_result.setData(productCategoryList);
            pagerVo_result.setTotal(total);
            return pagerVo_result;
        }
    }

    @Override
    public boolean save(ProductCategory productCategory) {
        ProductCategory byCategoryId = productCategoryMapper.getByCategoryId(productCategory);
        ProductCategory byCategoryName = productCategoryMapper.getByCategoryName(productCategory);
        if (byCategoryId != null || byCategoryName != null){
            //商品类别编号或商品类别名称存在
            return false;
        }else if (productCategory.getCategoryId() == null || productCategory.getCategoryName() == null || productCategory.getCategoryName().isEmpty()){
            return false;
        }else {
            //保存商品类别
            productCategoryMapper.save(productCategory);
            return true;
        }
    }

    @Override
    public ProductCategory getByCategoryId(ProductCategory productCategory) {
        if (productCategory.getCategoryId() == null){
            return null;
        }
        ProductCategory category = productCategoryMapper.getByCategoryId(productCategory);
        if (category == null){
            return null;
        }else {
            return category;
        }
    }

    @Override
    public boolean updateById(ProductCategory productCategory) {
        if (productCategory.getCategoryName() == null || productCategory.getCategoryName() == ""){
            return false;
        }
        productCategoryMapper.updateById(productCategory);
        return true;
    }

    @Override
    public boolean removeByIdList(List<ProductCategory> productCategoryList) {
        if (productCategoryList == null || productCategoryList.size() == 0){
            return false;
        }
        int row = productCategoryMapper.removeByIdList(productCategoryList);
        if (row != 0){
            return true;
        }else {
            return false;
        }
    }
}
