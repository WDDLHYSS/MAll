package com.wddlhyss.gmall.manage.service.impl;

import com.wddlhyss.gmall.beans.PmsSkuAttrValue;
import com.wddlhyss.gmall.beans.PmsSkuImage;
import com.wddlhyss.gmall.beans.PmsSkuInfo;
import com.wddlhyss.gmall.beans.PmsSkuSaleAttrValue;
import com.wddlhyss.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.wddlhyss.gmall.manage.mapper.PmsSkuImageMapper;
import com.wddlhyss.gmall.manage.mapper.PmsSkuInfoMapper;
import com.wddlhyss.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.wddlhyss.gmall.service.SkuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;


    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        //插入skuinfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();
        //插入平台属性
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }
        //插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValues = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValues) {
            skuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(skuSaleAttrValue);
        }
        //插入图片
        List<PmsSkuImage> skuImages = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage skuImage : skuImages) {
            skuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(skuImage);
        }
    }
}
