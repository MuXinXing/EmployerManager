package com.mx.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author MX
 */
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        //设置请求编码为utf-8
        servletResponse.setCharacterEncoding("utf-8");
        //设置响应编码为utf-8
        servletResponse.setContentType("text/html;charset=UTF-8");
        //设置客户端响应编码
        filterChain.doFilter(servletRequest, servletResponse);
        //设置过滤器链(req,resp)
    }
}
