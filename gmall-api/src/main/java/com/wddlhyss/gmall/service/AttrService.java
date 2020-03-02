package com.wddlhyss.gmall.service;


import com.wddlhyss.gmall.beans.PmsBaseAttrInfo;
import com.wddlhyss.gmall.beans.PmsBaseAttrValue;
import com.wddlhyss.gmall.beans.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> attrinfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
