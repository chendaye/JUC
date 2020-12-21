# wei微服务核心

> 思想，把功能模块分布式部署（传统的是一个集合，整体部署，无法细粒度的管理）；
> 不同模块可以使用不同的语言来开发。只要保证协调通信即可


> 带来的问题（根本原因：网络是不可靠的 ）：

- API网关，服务路由：用户如何访问
- HTTP、RPC通信框架，服务调用：服务之间的通信
- 服务注册与发发现，解决高可用：管理服务
- 熔断机制，服务降级：解决服务挂了怎么办

> 解决方案：

> Spring Cloud NetFix 一站式解决方案

- API网关：zuul组件
- 通信框架：Feign-->HTTP通信-->同步阻塞
- 服务注册与发现：Eureka
- 熔断机制：Hystrix

> Apache Dubbo zookeeper 

- API网关：无，自己实现或找第三方
- 通信框架： Dubbo 高性能 RPC通信框架
- 服务注册于发现： zookeeper
- 熔断机制：无，借助了 Hystrix

> Spring Cloud Alibaba


# 下一代微服务架构

> 服务网格


# Spring Cloud

> Spring Cloud 是一个生态