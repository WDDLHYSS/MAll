package com.wddlhyss.gmall.manage.controller;

import com.wddlhyss.gmall.beans.PmsProductInfo;
import com.wddlhyss.gmall.beans.PmsSkuInfo;
import com.wddlhyss.gmall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SkuController {


    @Reference
    SkuService skuService;

    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        //将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());

        //处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();

        if (StringUtils.isBlank(skuDefaultImg)) {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
