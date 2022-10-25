package com.woniuxy.busconfig.configuration;

import com.woniuxy.wuye.common.entity.TbChargeType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;

/**
 * @author author
 * @create 2022-09-2022/9/16 11:03
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, TbChargeType> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, TbChargeType> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //修改默认序列化器
        //template.setDefaultSerializer(RedisSerializer.json());
        //分别设置k和V的序列化格式 K--String   V--JSON
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(RedisSerializer.json());
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.json());
        return template;
    }
}
