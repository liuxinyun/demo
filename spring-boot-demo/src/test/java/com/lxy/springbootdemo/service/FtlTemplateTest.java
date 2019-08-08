package com.lxy.springbootdemo.service;

import com.lxy.springbootdemo.SpringBootDemoApplicationTests;
import com.lxy.springbootdemo.enums.SexEnum;
import com.lxy.springbootdemo.util.FreemarkerUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyun
 * @date 2019/8/4 22:59
 */
public class FtlTemplateTest extends SpringBootDemoApplicationTests {

    @Autowired
    private IFtlTemplateService ftlTemplateService;

    @Test
    public void testEmail() {
        Map<String, Object> model = new HashMap<>();
        model.put("emailHead", "刘小杰");
        model.put("orderNo", "666888");
        model.put("institutionName", "孩子的乐园");
        model.put("goodsAmount", 99999.99d);
        model.put("consigneeName", "秦小运");
        model.put("consigneePhone", "15012345678");
        model.put("consigneeAddress", "宇宙中心");
        List<Map<String, Object>> skuList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String,Object> skuMap = new HashMap<>();
            skuMap.put("goodsName", "名称" + i);
            skuMap.put("barcode", "条码" + i);
            skuMap.put("num", "购买数量" + i);
            skuList.add(skuMap);
        }
        model.put("skuList", skuList);
        model.put("sex", 1);
        FreemarkerUtil.importEnum2Ftl(SexEnum.class, model);
        System.out.println(ftlTemplateService.getContent("OrderNotifyMail.ftl", model));
    }
}
