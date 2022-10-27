package com.woniuxy.batchservice.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.woniuxy.batchservice.jilianutils.entity.Project;
import com.woniuxy.batchservice.jilianutils.service.JilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jilian")
public class JiLianController {
    @Autowired
    JilianService jilianService;
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("get")
    public List<Project> get() {
        ListOperations listOperations = redisTemplate.opsForList();
if(redisTemplate.hasKey("级联")&&listOperations.size("级联")!=0){
    System.out.println("拿缓存");
   return listOperations.range("级联",0,-1);
}
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        /*om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);*/
        jackson2JsonRedisSerializer.setObjectMapper(om);


        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        List<Project> projects = jilianService.getJilLianProject();
        listOperations.rightPushAll("级联", projects);
        return projects;
    }
}
