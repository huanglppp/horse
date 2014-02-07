环境要求：jdk1.7+tomcat7+servlet3.0+eclipse4.3

框架技术(持续更新)：
1、 集成springMVC4.0.1          （前台展示）
2、 集成spring4.0.1             （spring容器）
4、 集成mybatis3.2.4            （新增、修改、编辑、删除和查询功能）
5、 集成junit4.11               （单元测试）
6、 集成ehcache2.7.5            （缓存）
7、 集成slf4j1.7.5              （日志）
8、 集成activiti5.14            （工作流）
9、 集成spring security 3.2.0   （安全框架）
10、集成JMock2.6.0			    （mock）
11、集成maven3.1				 (部署打包)

基础功能都包括在common包下:
activiti    工作流最基本的服务，待改进
basedao		所有dao的父类
cache       缓存
dao         操作数据库基本包
util		常用的工具类


security相关功能在security包下

权限测试用的数据在：/config/spring/测试数据.sql

web		               安全框架验证流程相关控制器
