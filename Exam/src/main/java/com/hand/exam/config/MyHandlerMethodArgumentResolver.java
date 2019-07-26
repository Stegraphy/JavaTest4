package com.hand.exam.config;

import com.hand.exam.annotation.MyRequestBoy;
import com.hand.exam.entity.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
@Component
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(MyRequestBoy.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        try {
            Page page1 = new Page();
            page1.setPage(Integer.parseInt(page));
            page1.setPage(Integer.parseInt(pageSize));
            page1.setSort("ASC");
            return page1;
        } catch (Exception e) {
            return false;
        }

    }
}
