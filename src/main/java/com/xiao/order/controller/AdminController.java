package com.xiao.order.controller;

import com.xiao.order.model.AdminInfo;
import com.xiao.order.model.Orders;
import com.xiao.order.model.ProductCategory;
import com.xiao.order.model.ProductInfo;
import com.xiao.order.service.AdminInfoService;
import com.xiao.order.service.OrdersService;
import com.xiao.order.service.ProductCategoryService;
import com.xiao.order.service.ProductInfoService;
import com.xiao.order.vo.PagerVo;
import com.xiao.order.vo.ProductVo;
import com.xiao.order.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 23:48
 */
@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

    @Autowired
    private AdminInfoService adminInfoService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping(value = "login")
    public String login(AdminInfo adminInfo, HttpSession session, Map<String, Object> map){

        AdminInfo adminInfo_result = adminInfoService.login(adminInfo);
        if (adminInfo_result != null){
            //登陆成功
            session.setAttribute("admin",adminInfo_result);
            return "redirect:/index.html";
        }else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping(value = "logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @GetMapping(value = "toHome")
    public String toHome(){
        return "home";//订单页面
    }

    /**
     * 查询所有订单
     * @return
     */
    @GetMapping(value = "orderList")
    @ResponseBody
    public ResultVo orderList(){
        ResultVo resultVo = new ResultVo();

        List<Orders> ordersList = ordersService.list();
        if (ordersList != null){
            //订单存在
            resultVo.setCode(0);
            resultVo.setMsg("success");
            resultVo.setCount(ordersList.size());
            resultVo.setData(ordersList);
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("订单不存在");
        }

        return resultVo;
    }

    //查询所有的商品类别，放入请求域中，返回商品管理页面
    @GetMapping(value = "categoryList")
    public String categoryList(Model model){

        List<ProductCategory> productCategoryList = productCategoryService.getAll();
        if (productCategoryList != null){
            //商品类别存在
            model.addAttribute("productCategoryList",productCategoryList);
        }

        return "product";
    }

    //获取商品信息,参数：商品类别名称，搜索类型(商品名称)，关键字
    @GetMapping(value = "productList")
    @ResponseBody
    public ResultVo productList(@RequestParam(value = "searchType") String searchType,
                                @RequestParam(value = "categoryName") String categoryName,@RequestParam(value = "key") String key){

        ResultVo resultVo = new ResultVo();
        ProductVo productVo = new ProductVo();

        if (searchType.equals("productName")){
            productVo.setProductName(key);
            productVo.setCategoryName(categoryName);
            List<ProductVo> productVoList = productInfoService.getByNameAndCategoryName(productVo);
            if (productVoList != null){
                //商品存在
                resultVo.setCode(0);
                resultVo.setMsg("success");
                resultVo.setCount(productVoList.size());
                resultVo.setData(productVoList);
            }else {
                resultVo.setCode(1);
                resultVo.setMsg("暂无相关信息!");
            }
        }

        return resultVo;
    }

    //查询所有的商品类别，放入请求域中，返回商品添加页面
    @GetMapping(value = "toProductAdd")
    public String toProductAdd(Model model){

        List<ProductCategory> productCategoryList = productCategoryService.getAll();
        if (productCategoryList != null){
            //商品类别存在
            model.addAttribute("productCategoryList",productCategoryList);
        }

        return "productadd";
    }

    //保存商品信息，返回product.html
    @PostMapping(value = "addProduct")
    public String addProduct(Model model,ProductInfo productInfo){

        int code = productInfoService.save(productInfo);
        if (code == 0){
            //保存成功
            model.addAttribute("msg","保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }

        return "product";

    }

    //获取所有商品类别（分页）
    @GetMapping("productCategoryListPage")
    @ResponseBody
    public ResultVo productCategoryListPage(PagerVo pagerVo){

        ResultVo resultVo = new ResultVo();

        PagerVo pagerVo_result = productCategoryService.listPage(pagerVo);
        if (pagerVo_result != null){
            //商品类别存在
            resultVo.setCode(0);
            resultVo.setMsg("success");
            resultVo.setData(pagerVo_result.getData());
            resultVo.setCount(pagerVo_result.getTotal());
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("暂无相关信息!");
        }

        return resultVo;
    }

    //查询所有商品类别，商品类别页面
    @GetMapping("productCategoryList")
    public String productCategoryList(Model model){

        List<ProductCategory> productCategoryList = productCategoryService.getAll();
        if (productCategoryList != null){
            //商品类别存在
            model.addAttribute("productCategoryList",productCategoryList);
        }
        return "productCategory";
    }

    //按商品类名查询商品，将查询结果返回
    @GetMapping("productCategoryListByName")
    @ResponseBody
    public ResultVo productCategoryListByName(PagerVo pagerVo,ProductCategory productCategory){
        ResultVo resultVo = new ResultVo();
        pagerVo.setData(productCategory);


        PagerVo pagerVo_result = productCategoryService.listByCategoryNamePage(pagerVo);
        if (pagerVo_result != null){
            //商品类别存在
            resultVo.setCode(0);
            resultVo.setMsg("ok!");
            resultVo.setData(pagerVo_result.getData());
            resultVo.setCount(pagerVo_result.getTotal());
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("暂无相关信息!");
        }

        return resultVo;
    }

    //来到商品类别添加页面
    @GetMapping("toProductCategoryAdd")
    public String toProductCategoryAdd(){
        return "productCategoryAdd";
    }

    //保存商品类别，返回productCategory.html
    @PostMapping("addProductCategory")
    public String addProductCategory(Model model,ProductCategory productCategory){

        boolean save = productCategoryService.save(productCategory);
        if (save){
            //保存成功
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败,商品编号或商品名称已存在!");
        }

        return "productCategory";
    }

    //来到商品类别修改页面，productCategoryUpdate.html,把信息显示出来
    @GetMapping("toProductCategoryUpdate")
    public String toProductCategoryUpdate(ProductCategory productCategory,Model model){

        ProductCategory category = productCategoryService.getByCategoryId(productCategory);
        if (category != null){
            model.addAttribute("category",category);
        }

        return "productCategoryUpdate";
    }

    //修改商品类别，返回productCategory.html
    @PostMapping("updateProductCategory")
    public String updateProductCategory(ProductCategory productCategory,Model model){

        boolean flag = productCategoryService.updateById(productCategory);
        if (flag){
            model.addAttribute("msg","修改成功!");
        }else {
            model.addAttribute("msg","修改失败!");
        }

        return "productCategory";
    }

    //删除商品类别
    @PostMapping("deleteProductCategoryList")
    @ResponseBody
    public ResultVo deleteProductCategoryList(@RequestBody List<ProductCategory> productCategoryList){
        ResultVo resultVo = new ResultVo();

        boolean isRemove = productCategoryService.removeByIdList(productCategoryList);
        if (isRemove){
            //删除成功
            resultVo.setCode(0);
            resultVo.setMsg("删除成功!");
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("删除失败！请联系开发人员!");
        }

        return resultVo;
    }

    //删除商品信息
    @PostMapping("deleteProductInfoList")
    @ResponseBody
    public ResultVo deleteProductInfoList(@RequestBody List<ProductInfo> productInfoList){
        ResultVo resultVo = new ResultVo();

        boolean isRemove = productInfoService.removeByProductIdList(productInfoList);
        if (isRemove){
            //删除成功
            resultVo.setCode(0);
            resultVo.setMsg("success");
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("删除失败!");
        }

        return resultVo;
    }

}
