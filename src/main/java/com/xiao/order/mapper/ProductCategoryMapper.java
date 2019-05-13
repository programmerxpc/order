package com.xiao.order.mapper;

import com.xiao.order.mapper.provider.ProductCategoryProvider;
import com.xiao.order.model.ProductCategory;
import com.xiao.order.vo.PagerVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author XiaoPengCheng
 * @create 2019-04-22 23:15
 */
public interface ProductCategoryMapper {

    @Insert("INSERT INTO product_category(category_id,category_name) VALUES(#{categoryId},#{categoryName})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int save(ProductCategory productCategory);

    @Update("UPDATE product_category SET category_id=#{categoryId},category_name=#{categoryName} WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int updateById(ProductCategory productCategory);

    @Select("SELECT * FROM product_category")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<ProductCategory> list();

    /**
     * 获取商品类别总数
     * @return
     */
    @Select("SELECT COUNT(id) AS id FROM product_category")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int getCount();

    /**
     * 查询当前页的显示的记录数
     * @param page 当前页
     * @param limit 每页显示的记录数
     * @return
     */
    @Select("SELECT * FROM product_category LIMIT #{page},#{limit}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<ProductCategory> listPage(@Param("page") Integer page, @Param("limit") Integer limit);

    /**
     * 根据类别名称查询，如果名称为空查询所有，如果不为空按条件查
     * @param categoryName
     * @param page
     * @param limit
     * @return
     */
    @SelectProvider(type = ProductCategoryProvider.class, method = "listByCategoryNamePage")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<ProductCategory> listByCategoryNamePage(@Param("categoryName") String categoryName, @Param("page") Integer page, @Param("limit") Integer limit);

    /**
     * 查询商品类别
     * @param productCategory 商品编号
     * @return 商品类别信息
     */
    @Select("SELECT * FROM product_category WHERE category_id=#{categoryId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    ProductCategory getByCategoryId(ProductCategory productCategory);

    /**
     * 查询商品类别
     * @param productCategory 商品类别名称
     * @return
     */
    @Select("SELECT * FROM product_category WHERE category_name=#{categoryName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    ProductCategory getByCategoryName(ProductCategory productCategory);

    /**
     * 根据类别名称获取总数，类别名称为空查询所有，不为空，按条件查
     * @param productCategory 类别名称
     * @return
     */
    @SelectProvider(type = ProductCategoryProvider.class, method = "getCountByCategoryName")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int getCountByCategoryName(ProductCategory productCategory);

    @DeleteProvider(type = ProductCategoryProvider.class, method = "removeByIdList")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int removeByIdList(List<ProductCategory> productCategoryList);

}
