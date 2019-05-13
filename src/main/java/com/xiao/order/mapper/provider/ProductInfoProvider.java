package com.xiao.order.mapper.provider;

import com.xiao.order.model.ProductInfo;
import com.xiao.order.vo.ProductVo;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoPengCheng
 * @create 2019-04-27 23:23
 */
public class ProductInfoProvider {

    public String listByNameAndCategoryName(ProductVo productVo){
        return new SQL(){{
            SELECT("b.product_id","b.product_name","b.product_price","b.product_description","b.create_time","b.update_time","a.category_id","a.category_name");
            FROM("product_category a");
            INNER_JOIN("product_info b ON a.category_id=b.category_id");
            if (productVo.getProductName() != null && productVo.getProductName() != ""){
                WHERE("product_name = #{productName}");
            }
            if (productVo.getCategoryName() != null && productVo.getCategoryName() != ""){
                WHERE("category_name = #{categoryName}");
            }
        }}.toString();
    }

    public String removeByProductIdList(Map map){
        List<ProductInfo> productInfoList = (List<ProductInfo>) map.get("list");
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM product_info WHERE product_id IN(");
        for (int i = 0; i < productInfoList.size(); i++){
            sb.append("'").append(productInfoList.get(i).getProductId()).append("'");
            if (i < productInfoList.size() - 1)
                sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }

}
