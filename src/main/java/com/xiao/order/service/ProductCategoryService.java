package com.xiao.order.service;

import com.xiao.order.model.ProductCategory;
import com.xiao.order.vo.PagerVo;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-28 10:35
 */
public interface ProductCategoryService {

    /**
     * 获取所有商品类别
     * @return
     */
    List<ProductCategory> getAll();

    /**
     * 查询商品类别
     * @param pagerVo 当前页page,每页显示记录数limit
     * @return PageInfo 当前页的商品信息（包含分页详细信息）
     */
    PagerVo listPage(PagerVo pagerVo);

    /**
     * 查询商品类别
     * 如果传入类名为空,查询所有；不为空按条件查
     * @param pagerVo 商品类名
     * @return 当前页的商品类别（包含分页详细信息）
     */
    PagerVo listByCategoryNamePage(PagerVo pagerVo);

    /**
     * 保存商品类别，如果商品编号或商品类别已存在，保存失败
     * @param productCategory 商品编号,商品类别
     * @return 插入成功返回true，失败返回false
     */
    boolean save(ProductCategory productCategory);

    /**
     * 查询商品类别
     * @param productCategory 商品编号
     * @return
     */
    ProductCategory getByCategoryId(ProductCategory productCategory);

    /**
     * 修改商品类别
     * @param productCategory 主键，商品编号，商品名称
     * @return 修改成功返回true，失败返回false
     */
    boolean updateById(ProductCategory productCategory);

    /**
     * 删除商品类别
     * @param productCategoryList 主键
     * @return 删除成功返回true，删除失败返回false
     */
    boolean removeByIdList(List<ProductCategory> productCategoryList);

}
