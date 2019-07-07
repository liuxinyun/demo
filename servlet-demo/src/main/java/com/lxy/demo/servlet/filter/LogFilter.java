package com.lxy.demo.servlet.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liuxinyun
 * @date 2019/7/7 20:25
 */
public class LogFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String name;

    @Override
    public void init(FilterConfig filterConfig) {
        name = filterConfig.getInitParameter("name");
        logger.info("{} logFilter init...", name);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        chain.doFilter(request, response);
        logger.info("请求{}耗时：{}ms", path + request.getRequestURI(), System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {

    }
}
