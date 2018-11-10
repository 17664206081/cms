package com.fzy.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: RedisConfig
 * @description: Redis配置
 *
 * --常用注解描述
 * @Cacheable (key="",cacheNames='') 缓冲中没有查询数据库
 *  keyGenerator 自定义key生成策略
 *  --条件缓冲
 *  condition: 在执行方法前，condition的值为true，则缓存数据
 *  unless ：在执行方法后，判断unless ，如果值为true，则不缓存数据
 *  condition 和unless可以同时使用，则此时只缓存同时满足两者的记录
 * @CacheEvict 删除缓存
 *  allEntries = true: 清空命名空间缓存里的所有值
 *  allEntries = false: 默认值，此时只删除key对应的值
 * @CachePut 每次执行都会执行方法，无论缓存里是否有值
 * @CacheConfig 类级别的注解：如果我们在此注解中定义cacheNames
 * 则此类中的所有方法上 @Cacheable的cacheNames默认都是此值
 * @author: fzy
 * @date: 2018-10-17 15:52
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    //重写缓存的key生成策略
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(":"+method.getName());
                for (Object obj : params) {
                    sb.append(":"+obj.toString());
                }
                return sb.toString();
            }
        };
    }

    //缓存管理器
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间 单位秒
        rcm.setDefaultExpiration(60);
        return rcm;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}
