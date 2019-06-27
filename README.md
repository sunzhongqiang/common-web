# common-web

主要有一下几个类：ResultData,WebUtils,SessionUtils,ValidatorUtils

## 用法

#### gradle
```
dependencies {
	implementation 'com.mmk:common-web:1.0.6'
}
```

#### maven
```
<dependency>
    <groupId>com.mmk</groupId>
    <artifactId>common-web</artifactId>
    <version>1.0.7</version>
</dependency>
```

## ResultData

这个类主要是为了封装web端处理的结果数据给前端

#### 常规用法
一般我们只需要成功的时候返回结果即可，错误的时候返回错误信息即可；
```
//快速返回成功结果集，并把结果放在 content 里返回 {'content':[{},{}]}
Page<Trade> tradePage = tradeService.list(tradeDto, pageable);
return ResultData.SUCCESS("订单列表查询").content(tradePage);

//or 只返回业务数据
return ResultData.SUCCESS(tradePage);
//or
return ResultData.SUCCESS().content(tradePage);

//快速返回错误
return ResultData.ERROR("删除失败");

return ResultData.ERROR("删除失败");
//or 返回错误的信息同时返回错误的业务数据
return ResultData.ERROR("errormessage").content(object);

//如果成功返回多个数据的话
Map<String,Object> data = {}....;
ResultData.SUCCESS(data)

```

## WebUtils

方便获取Web容器中的request，response 和 session

```java
// 获得Request
WebUtils.getRequest();

// 获得session
WebUtils.getSession();

//获得Response
WebUtils.getResponse();

```

## SessionUtils

主要是为了获取session 和session中的数值,为了方便直接对session进行取值赋值

```java
SessionUtils.set(key,value)

Object value = SessionUtils.get(key)

String stringValue = SessionUtils.getString(key);

Long longValue = SessionUtils.getLong(key);

...

```



## ValidatorUtils

主要是针对web端的参数进行校验的一个工具类

```java
ValidatorUtils.isCorrectIdcard()  //身份证校验
ValidatorUtils.isPhone()          // 电话校验
ValidatorUtils.checkPassword()    //密码是否符合规范
ValidatorUtils.checkNickname()    //用户名是否符合规范

```
