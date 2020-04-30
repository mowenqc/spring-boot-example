1. 搭建一个activemq服务，从官网下载最新版本：http://activemq.apache.org/
安装，直接运行.bin/activemq start
默认访问端口8161， 连接端口61616
2. 新建一个项目spring boot activemq 
导入包：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-activemq</artifactId>
        </dependency>

        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-pool</artifactId>
            <version>5.15.12</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>5.2.5.RELEASE</version>
        </dependency>
3. 配置 application.yml文件
spring:
  activemq:
    broker-url: tcp://192.168.119.248:61616
    close-timeout: 5000
    packages:
      trust-all: true
    pool:
      enabled: true
      max-connections: 50
    user: admin
    password: admin
4. 在application上加上注解：@EnableJms
5. 初始化bean
@Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker-url"));
        connectionFactory.setUserName(env.getProperty("spring.activemq.user"));
        connectionFactory.setPassword(env.getProperty("spring.activemq.password"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate genJmsTemplate() {
        return new JmsTemplate(connectionFactory());

    }

    @Bean
    public JmsMessagingTemplate jmsMessageTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }
6. 建立一个provider 一个customer一个生产者一个消费者
运行看是否能够 正常生产与消费