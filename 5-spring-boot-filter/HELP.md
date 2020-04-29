Druid+Mybatis+MySql使用指南
1. 导入依赖包
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>

         <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.22</version>
        </dependency>
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
2. application.yml配置文件配置druid+mybatis
spring:
  datasource:
    druid:
      type: com.alibaba.druid.pool.DruidDataSource
      driver-class-name: com.mysql.jdbc.Driver
      url: jdbc:mysql://192.168.119.249/test?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&idleConnectionTestPeriod=120&preferredTestQuery=select now()&serverTimezone=UTC
      username: root
      password: OOWHGyCWI2w6Gw2Z
      initial-size: 100
      min-idle: 5
      max-active: 100
      max-wait: 500
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
      validation-query: select '1'
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      pool-prepared-statements: true
      max-open-prepared-statements: 20
      max-pool-prepared-statement-per-connection-size: 20
      filters: stat,wall
      filter:
        stat:
          log-slow-sql: true
 mybatis:
   mapper-locations: classpath:/mapper/*.xml

3. 创建一一张表做测试
CREATE TABLE `test`.`customer` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
    `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
    `ip` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '注册的ip地址',
    `status` tinyint(1) NULL DEFAULT NULL COMMENT '用户状态，1 正常 0 关闭',
    `create_time` datetime NULL DEFAULT NULL COMMENT '加入时间',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) 
)
4. 写一个登录注册逻辑

