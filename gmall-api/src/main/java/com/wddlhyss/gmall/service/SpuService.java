package com.wddlhyss.gmall.service;

import com.wddlhyss.gmall.beans.PmsProductImage;
import com.wddlhyss.gmall.beans.PmsProductInfo;
import com.wddlhyss.gmall.beans.PmsProductSaleAttr;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);


    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
