# 新建项目

![img_01](img/img_01.png)
![img_02](img/img_02.png)
![img_02](img/img_03.png)
![img_02](img/img_04.png)
![img_02](img/img_05.png)
![img_02](img/img_06.png)
![img_02](img/img_07.png)
![img_02](img/img_08.png)
![img_02](img/img_09.png

# 配置可以看spring github的例子

# mybatis 三剑客

[参考](https://juejin.cn/post/6844903619850928141)

> Mybatis-Generator:Mybatis属于半自动ORM，在使用这个框架中，工作量最大的就是书写Mapping的映射文件，
> 由于手动书写很容易出错，我们可以利用Mybatis-Generator来帮我们自动生成文件(Mapper文件、Dao接口、JavaBean）

> Mybatis-plugin:对于Mybatis的配置文件编辑少不了这个插件帮忙(IDEA中Free Mybatis plugin)

> Mybatis-Helper:使用Mybatis的物理分页插件；简化sql的编写。PageHelper插件在github上有开源

# 文件结构

> pojo:表 （映射）

> dao:Model（增删改查）

> service: 业务逻辑（调用到层方法实现业务）

> common: 公用类

> util: 工具类