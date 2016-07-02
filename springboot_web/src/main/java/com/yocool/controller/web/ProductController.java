package com.yocool.controller.web;

import com.yocool.model.Product;
import com.yocool.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 产品控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private ProductService productService;

    /**
     * 产品列表
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String prodList(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("prodList",productService.getAllProd());
        return "product/list";
    }

    /**
     * 产品详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String prodDetail(@PathVariable("id")int id,Model model){
        model.addAttribute("product",productService.getProdById(id));
        return "product/detail";
    }

    /**
     * 添加产品页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String prodCreatePage(){
        return "product/create";
    }

    /**
     * 添加产品
     * @param prod
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String prodCreate(Product prod){
        productService.addProduct(prod);
        return "redirect:/product/list";
    }

    /**
     * 删除产品
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
    public String prodDelete(@PathVariable("id")int id){
        productService.deleteProdById(id);
        return "redirect:/product/list";
    }


}
