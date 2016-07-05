# test_rabbitmq
####rabbitmq demo
####[走进RabbitMq](http://www.jianshu.com/p/a5f7fce67803)


###流程:
####消息生产者:  
1. 获取Connection  
2. 获取Channel  
3. 定义Exchange,Queue  
4. 使用一个RoutingKey将Queue Binding到一个Exchange上  
5. 通过指定一个Exchange和一个RoutingKey来将消息发送到对应的Queue上  

####消息消费者:  
1.获取Connection  
2.获取Channel  
3.指定一个**Queue**直接到它关心的Queue上取消息,它对Exchange,RoutingKey及如何binding都不关心,到对应的Queue上取消息就OK了.  

一个Client发送消息,哪些Client可以收到消息,其核心就在于Exchange,RoutingKey,Queue的关系上.  
RoutingKey就像是一个中间表,将两个表的数据进行多对多关联,只不过对于相同的Exchange和Queue,可以使用不同的RoutingKey重复关联多次  

