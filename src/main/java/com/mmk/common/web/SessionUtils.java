package com.mmk.common.web;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {

  public static HttpSession getSession() {
   return WebUtils.getSession();
  }


  public static void set(String name,Object value){
    getSession().setAttribute(name,value);
  }


  public static Object get(String name){
    return getSession().getAttribute(name);
  }


  public static String getString(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return value.toString();
  }

  public static Long getLong(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return Long.valueOf(value.toString());
  }

  public static Integer getInteger(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return Integer.valueOf(value.toString());
  }

  public static Double getDouble(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return Double.valueOf(value.toString());
  }

  public static BigDecimal getBigDecimal(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return BigDecimal.valueOf(Double.valueOf(value.toString()));
  }

  public static  <T> T getObject(String name){
    Object value = get(name);
    if(value  == null){
      return null;
    }
    return  (T) value;
  }

}
