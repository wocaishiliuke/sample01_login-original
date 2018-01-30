# sample01_login-original
完成最简登陆

## 前期准备
- 导包:c3p0和mysql驱动
- c3p0工具类和配置文件(四大金刚)
- 数据库创建,初始数据插入

## 编码
- 登陆页,注意action属性中的路径是客户端路径,所以绝对路径中需要有项目名,post提交表单
- 自定义LoginServlet,配置servlet mapping,doPost中完成取参,调用登陆业务类UserService,根据返回值判断是否登陆成功
- UserService中调用UserDao,在DAO层完成SQL查询,并返回
