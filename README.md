#环境说明
1. springboot
2. mybatis
3. mysql
4. redis
5. rabbitmq

#功能说明
- 物品类别
- 物品信息
- 购物车
- 热门推荐

#说明
运行本项目前必须安装gradle

#ssl证书生成(使用jdk 自带的工具生成)
1. 在当前项目下打开cmd
```
keytool -genkey -alias tomcat -keyalg RSA -keystore ./server.keystore 
``` 
![图片暂时无法显示](https://github.com/17664206081/cms/blob/master/image/menu.saveimg.savepath20181107101411.jpg)

#导入数据库脚本
1. mysql -h localhost -u root -p
2. create database cms;(创建数据库)
3. use cms;(进入cms数据库下面)
4. source cms.sql (导入数据文件)
