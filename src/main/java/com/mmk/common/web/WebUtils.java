package com.mmk.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebUtils {

  /**
   * 获取容器中的session
   * @return 当前使用的session
   */
  public static HttpSession getSession() {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
    return request.getSession();
  }

  /**
   * 获取当前请求的request
   * @return 当前请求的request
   */
  public static HttpServletRequest getRequest() {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
    return request;
  }

  /**
   * 获取当前请求对应的响应
   * @return 当前请求的响应
   */
  public static HttpServletResponse getResponse() {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    HttpServletResponse response = ((ServletRequestAttributes) ra).getResponse();
    return response;
  }

}
