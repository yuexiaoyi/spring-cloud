eureka-client:服务的提供者
eureka-server：注册中心
ribbon-consumer：服务消费者，消费eureka-client的服务
gateway-zuul:网关
注册中心地址：http://localhost:1111
服务提供者地址：http://localhost:1112 服务名称：user-service
服务消费者地址：http://localhost:1113 服务名称：ribbon-consumer
