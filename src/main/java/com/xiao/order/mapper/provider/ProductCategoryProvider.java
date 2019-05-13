package com.xiao.order.mapper.provider;

import com.xiao.order.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoPengCheng
 * @create 2019-04-30 23:30
 */
public class ProductCategoryProvider {

    public String listByCategoryNamePage(@Param("categoryName") String categoryName, @Param("page") Integer page, @Param("limit") Integer limit){
        StringBuffer sb = new StringBuffer("SELECT * FROM product_category ");
        if (categoryName !=null && categoryName != ""){
            sb.append("WHERE category_name like concat('%',#{categoryName},'%') ");
        }
        sb.append("LIMIT #{page},#{limit} ");

        return sb.toString();
    }

    public String getCountByCategoryName(ProductCategory productCategory){
        return new SQL(){{
            SELECT("COUNT(id) as id");
            FROM("product_category");
            if (productCategory.getCategoryName() != null && productCategory.getCategoryName() != ""){
                WHERE("category_name = #{categoryName}");
            }
        }}.toString();
    }

    public String removeByIdList(Map map){
        List<ProductCategory> productCategoryList = (List<ProductCategory>) map.get("list");
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM product_category WHERE id IN(");
        for (int i = 0; i < productCategoryList.size(); i++){
            sb.append("'").append(productCategoryList.get(i).getId()).append("'");
            if (i < productCategoryList.size() - 1)
                sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }

}
