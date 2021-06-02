> 装饰着模式 比继承更灵活，在不改变类的情况下，增加功能

- 扩展一个类的功能，或者给一个类添加附加功能
- 动态给类添加功能，也可以动态的撤销


> 优点
- 是继承的补充，比继承灵活；不改变 原有类，增加功能
- 不同的装饰类可以排列组合
- 符合开闭原则 

> 缺点
- 出现更多代码，更多类，增加复杂性

> 装饰模式&代理模式
- 装饰模式注重在添加功能
- 代理模式注重控制访问 

> 装饰者模式&适配器模式
- 都是包装模式
- 装饰者模式：装饰者与被装饰者实现一个接口，或者装饰者是其子类
- 适配器模式：适配类和被适配的类有不同的结构