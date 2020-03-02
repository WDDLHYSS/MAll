package com.wddlhyss.gmall.manage.controller;

import com.wddlhyss.gmall.beans.PmsBaseCatalog1;
import com.wddlhyss.gmall.beans.PmsBaseCatalog2;
import com.wddlhyss.gmall.beans.PmsBaseCatalog3;
import com.wddlhyss.gmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin  //跨域注解
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = catalogService.getCatalog1();
        return pmsBaseCatalog1s;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        List<PmsBaseCatalog2> pmsBaseCatalog2s = catalogService.getCatalog2(catalog1Id);
        return pmsBaseCatalog2s;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        List<PmsBaseCatalog3> pmsBaseCatalog3s = catalogService.getCatalog3(catalog2Id);
        return pmsBaseCatalog3s;
    }
}
