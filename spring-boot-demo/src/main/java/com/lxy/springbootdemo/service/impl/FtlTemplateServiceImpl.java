package com.lxy.springbootdemo.service.impl;

import com.lxy.springbootdemo.service.IFtlTemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author liuxinyun
 * @date 2019/8/4 22:14
 */
@Service("ftlTemplateService")
public class FtlTemplateServiceImpl implements IFtlTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(FtlTemplateServiceImpl.class);

    @Resource
    private Configuration ftlConfiguration;

    @Override
    public String getContent(String templateName, Map<String, Object> model) {
        try {
            Template template = ftlConfiguration.getTemplate(templateName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (Exception e) {
            logger.error("获取[{}]模板异常", templateName, e);
        }
        return null;
    }
}
