//package com.example.springboottest.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.net.UnknownHostException;
//
///**
// * @author zjm
// * @desc 配置Redis
// * @date 2019/8/2 14:33
// */
////@Configuration
////@ConditionalOnClass(RedisOperations.class)
////@EnableConfigurationProperties(RedisProperties.class)
//public class RedisAutoConfiguration {
//
//    /*@Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")*/
//    public RedisTemplate<Object, Object> redisTemplate(
//RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//    @Bean
//    @ConditionalOnMissingBean
//    public StringRedisTemplate stringRedisTemplate(
//RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//}
