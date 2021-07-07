# stemstore

#### 介绍
成都信息工程大学，工程实践3，项目，实现一个游戏商城

#### 软件架构
前后端分离，测试


#### 使用说明

1.  application.properties 未追踪，模板如下

```
#======================================================
# 连接Redis数据库
#======================================================
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.database=0
#======================================================
#======================================================
# 设置SpringBoot默认的HikariDataSource数据源:连接MySQL
#  在Linux后端启动MYCAT数据库中间件:MYCAT的默认密码：123456 端口：8066
# 逻辑数据库：TESTDB
#======================================================
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:8066/TESTDB?allowPublicKeyRetrieval=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC
# =====================================================
# 开发阶段方便调试：控制台输出SQL语句：系统正式发布时建议关闭
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
# =====================================================
# 单元测试数据
# =====================================================
emp.empno=10000
emp.ename=杨岱峰
emp.job=Teacher
emp.mgr=1234
emp.hiredate=2021/07/02
emp.sal=20000.89
emp.comm=1000.67
emp.deptno=40
# =====================================================
```