
Rabbit消息队列交换机（exchange）的三种模式

1. 第一种是fanout，广播模式，顾名思义，就是所有的和交换机绑定的queue都会接收到exchange路由的消息
2. 第二种是direct，这个模式加入了一个routerKey，就是queue上可以配置一个路由的key，这个发送消息 的时候指定这个key，那么只有有这个key的queue才会接受到消息，一个queue可以写多个key
多个queue可以有相同的key，相对于fanout来说就是更加的灵活，通过给所有的queue设置key就可以实现fanout这种模式。
3. 第三种是topic，主题模式，和direct类似，不过这个key必须要写 `.` 例如 `china.weath`，`china.food` 主题就是如果需要订阅关于china的所有消息只需要这样写
`china.#` 那么这个就可以订阅到所有的关于china的消息。


![这就可以显示图片了](img/1.jpg "Magic Gardens")