package com.xiao.order.mapper;

import com.xiao.order.mapper.provider.ProductInfoProvider;
import com.xiao.order.model.ProductInfo;
import com.xiao.order.vo.ProductVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-27 17:26
 */
public interface ProductInfoMapper {

    /**
     * 获取所有商品
     * @return
     */
    @Select("SELECT * FROM product_info")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDescription", column = "product_description"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<ProductInfo> list();

    /**
     * 根据商品类别和商品名字动态查询
     * 当商品名称和类别名称不为空，按当前条件查；如果商品名称和类别名称为空，查询所有
     * @param productVo，包含参数：商品名称，类别名称
     * @return
     */
    @SelectProvider(type = ProductInfoProvider.class, method = "listByNameAndCategoryName")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDescription", column = "product_description"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "productCreateTime", column = "create_time"),
            @Result(property = "productUpdateTime", column = "update_time"),
            @Result(property = "categoryName", column = "category_name"),
    })
    List<ProductVo> listByNameAndCategoryName(ProductVo productVo);

    /**
     * 保存商品信息
     * @param productInfo
     * @return
     */
    @Insert("INSERT INTO product_info(product_name,product_price,product_description,category_id) VALUES(#{productName},#{productPrice},#{productDescription},#{categoryId})")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDescription", column = "product_description"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    int save(ProductInfo productInfo);

    /**
     * 删除商品信息
     * @param productInfoList 商品编号
     * @return
     */
    @DeleteProvider(type = ProductInfoProvider.class, method = "removeByProductIdList")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDescription", column = "product_description"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    int removeByProductIdList(List<ProductInfo> productInfoList);

    /**
     * 查询商品信息
     * @param productVo 类别名称
     * @return
     */
    @Select("SELECT * FROM product_info a LEFT JOIN product_category b ON a.category_id=b.category_id WHERE category_name=#{categoryName}")
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDescription", column = "product_description"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "productCreateTime", column = "create_time"),
            @Result(property = "productUpdateTime", column = "update_time"),
            @Result(property = "categoryName", column = "category_name"),
    })
    List<ProductVo> listByProductCategoryName(ProductVo productVo);

}
