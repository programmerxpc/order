package com.xiao.order.service;

import com.xiao.order.model.ProductInfo;
import com.xiao.order.vo.ProductVo;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-28 10:13
 */
public interface ProductInfoService {

    /**
     * 获取所有商品
     * @return
     */
    List<ProductInfo> getAll();

    /**
     * 根据商品名称和类别名称获取商品
     * @param productVo
     * @return
     */
    List<ProductVo> getByNameAndCategoryName(ProductVo productVo);

    /**
     * 保存商品信息
     * @param productInfo
     * @return 保存成功返回0，保存失败返回1
     */
    int save(ProductInfo productInfo);

    /**
     * 删除商品信息
     * @param productInfoList 商品编号
     * @return 删除成功返回true，失败返回false
     */
    boolean removeByProductIdList(List<ProductInfo> productInfoList);

    /**
     * 查询商品信息
     * @param productVo 类别名称
     * @return
     */
    List<ProductVo> listByProductCategoryName(ProductVo productVo);

}
