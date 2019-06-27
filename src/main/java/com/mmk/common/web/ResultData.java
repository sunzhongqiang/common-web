package com.mmk.common.web;

import java.util.HashMap;
import java.util.Map;

public class ResultData implements java.io.Serializable {

  /**
   * 默认生成的序列号
   */
  private static final long serialVersionUID = 1L;
  /**
   * 是否成功
   */
  private boolean success = false;
  /**
   * 更复杂的业务状态码，根据业务需要进行定义
   */
  private String statusCode;
  /**
   * 业务或者操作信息信息
   */
  private String msg = "";
  /**
   * 数据存储位置
   */
  private Map<String, Object> data = new HashMap<String,Object>(32);

  public ResultData() {}

  public ResultData(boolean success, String msg) {
    this.success = success;
    this.msg = msg;
  }

  public ResultData(boolean success,String statusCode, String msg) {
    this.statusCode = statusCode;
    this.success = success;
    this.msg = msg;
  }

  public ResultData(boolean success, String msg, Map<String, Object> data) {
    this.success = success;
    this.msg = msg;
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public ResultData setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public String getMsg() {
    return msg;
  }

  public ResultData setMsg(String msg) {
    this.msg = msg;
    return this;
  }


  public Map<String, Object> getData() {
    return data;
  }

  public ResultData setData(Map<String, Object> data) {
    this.data = data;
    return this;
  }

  public ResultData addData(String key, Object value) {
    this.data.put(key, value);
    return this;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public ResultData content(Object value){
    this.getData().put("content",value);
    return this;
  }

  public static ResultData SUCCESS(){
    return new ResultData(true,"");
  }

  public static ResultData SUCCESS(String msg){
    return new ResultData(true,msg);
  }


  public static ResultData SUCCESS(Object data){
    return ResultData.SUCCESS().content(data);
  }

  public static ResultData SUCCESS(Map<String,Object> data){
    return new ResultData(true,"",data);
  }

  /**
   * 构造错误的结果数据
   * @param errorMessage 错误的业务信息
   * @return 返回错误的ResultData实例
   */
  public static ResultData ERROR(String errorMessage){
    return new ResultData(false,errorMessage);
  }

}