
## 发布订阅模型

1. publisher 消息发布者
2. exchange 交换机，接受数据，然后根据配置的模式来发送给queue队列
3. queue 消息队列，放消息的地方
4. consumer 消息消费者

![图片](doc/img/mq.jpg)

## exchange交换机的三种区别
- Fanout 广播
- Direct 路由
- Topic 话题

[区别就是。。。。](doc/readme.md)


## SpringAMQP消息转换器
