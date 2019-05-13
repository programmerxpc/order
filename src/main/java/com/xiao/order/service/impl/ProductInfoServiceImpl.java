package com.xiao.order.service.impl;

import com.xiao.order.mapper.ProductInfoMapper;
import com.xiao.order.model.ProductInfo;
import com.xiao.order.service.ProductInfoService;
import com.xiao.order.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-28 10:19
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @SuppressWarnings("all")
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        List<ProductInfo> list = productInfoMapper.list();
        if (list != null && list.size() > 0){
            //商品存在
            return list;
        }else {
            return null;
        }
    }

    @Override
    public List<ProductVo> getByNameAndCategoryName(ProductVo productVo) {
        List<ProductVo> productVoList = productInfoMapper.listByNameAndCategoryName(productVo);
        if (productVoList != null && productVoList.size() > 0){
            return productVoList;
        }else {
            return null;
        }
    }

    @Override
    public int save(ProductInfo productInfo) {
        try {
            int row = productInfoMapper.save(productInfo);
            if (row != 0){
                //保存成功
                return 0;
            }else {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }
    }

    @Override
    public boolean removeByProductIdList(List<ProductInfo> productInfoList) {
        if (productInfoList == null || productInfoList.size() == 0){
            return false;
        }
        int row = productInfoMapper.removeByProductIdList(productInfoList);
        if (row != 0){
            //删除成功
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<ProductVo> listByProductCategoryName(ProductVo productVo) {
        if (productVo == null || productVo.getCategoryName() == null || productVo.getCategoryName().trim() == ""){
            return null;
        }
        List<ProductVo> productVoList = productInfoMapper.listByProductCategoryName(productVo);
        if (productVoList == null || productVoList.size() == 0){
            return null;
        }
        return productVoList;
    }
}
