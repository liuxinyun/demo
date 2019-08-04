package com.lxy.springbootdemo.service;

import java.util.Map;

/**
 * @author liuxinyun
 * @date 2019/8/4 22:13
 */
public interface IFtlTemplateService {

    /**
     * 根据模板名称和参数生成模板内容
     * @param templateName 模板名称
     * @param model 模板参数map
     * @return 模板内容
     */
    String getContent(String templateName, Map<String, Object> model);

}
