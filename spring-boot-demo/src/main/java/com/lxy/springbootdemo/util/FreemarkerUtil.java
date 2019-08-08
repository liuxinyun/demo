package com.lxy.springbootdemo.util;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 刘新运
 * @date 2019/8/8 10:57
 */
public class FreemarkerUtil {

    private static final Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);

    /**
     * 导入枚举到ftl中
     * @param enumClass
     * @param mv
     */
    @SuppressWarnings({ "rawtypes" })
    public static void importEnum2Ftl(Class enumClass, ModelAndView mv) {
        importEnum2Ftl(enumClass, mv.getModelMap());
    }

    public static void importEnum2Ftl(Class enumClass, Map<String, Object> modelMap) {
        try {
            String classFullName = enumClass.getName();
            String className = enumClass.getSimpleName();
            BeansWrapper wrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
            TemplateHashModel enumModels = wrapper.getEnumModels();
            TemplateHashModel enums = (TemplateHashModel) enumModels.get(classFullName);
            modelMap.put(className, enums);
        } catch (TemplateModelException e) {
            logger.error("import enum to ftl error, msg:{}", e.getMessage(), e);
        }
    }

    public static Object getStaticModel(Class<?> clz) {
        BeansWrapper wrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        try {
            return wrapper.getStaticModels().get(clz.getName());
        } catch (TemplateModelException e) {
            logger.error("getStaticModel error, msg:{}", e.getMessage(), e);
        }
        return null;
    }

}
