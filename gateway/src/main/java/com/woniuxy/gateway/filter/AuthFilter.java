//package com.woniuxy.gateway.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.woniuxy.util.JWTUtil;
//import com.woniuxy.util.ResponseResult;
//import com.woniuxy.util.ResultStatus;
//import com.woniuxy.util.TokenEnum;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;
//
//    // 该方法的作用于zuulfilter中的run方法是一样的：执行过滤处理的
//    // 参数1：交换机，主要包含了request、response、路由等等信息
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        System.out.println("gateway filter");
//
//        //1.获取uri
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//
//        //
//        String uri = request.getURI().getPath();
//
//        System.out.println(uri);
//
//        if (requireAuth(uri)){
//            // 校验refreshToken
//            List<String> refreshTokenList = request.getHeaders().get("refreshToken");
//
//            // 判断
//            if (refreshTokenList == null || refreshTokenList.size() == 0){
//                log.info("没带refreshToken");
//                // 没带refreshToken
//                return goLogin(response);
//            }
//
//            // refreshToken有，但是不一定合法：过期、非法
//            // 验证refreshToken：去redis中判断是否有这个key
//            String refreshToken = refreshTokenList.get(0);
//
//            if (!redisTemplate.hasKey(refreshToken)){
//                log.info("refreshToken非法");
//                // 非法或过期
//                return goLogin(response);
//            }
//
//
//            // 需要认证：获取token、并进行校验
//            List<String> tokenList = request.getHeaders().get("authorization");
//
//            // 判断是否有token
//            if (tokenList == null || tokenList.size() == 0){
//                log.info("没带Token");
//                // 没token
//                return goLogin(response);
//            }
//
//            // 执行到此处说明有token
//            String token = tokenList.get(0);
//
//            // token非法：去登录
//            if (JWTUtil.verify(token) == TokenEnum.TOKEN_BAD){
//                log.info("Token非法");
//                // 去登录
//                return goLogin(response);
//            }
//
//            // 过期
//            if (JWTUtil.verify(token) == TokenEnum.TOKEN_EXPIRE){
//                // 重新生成token：根据原来token中的用户信息生成新的token
//                token = JWTUtil.generateToken(JWTUtil.getUname(token));
//                log.info("filter--过期");
//                log.info(token);
//                // 将token放到redis，同时刷新refreshtoken的过期时间   覆盖原来的key
//                redisTemplate.opsForValue().set(refreshToken, token ,JWTUtil.REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
//
//                // 将新的token返回给前端
//                response.getHeaders().add("authorization", token);
//                // 暴露头
//                response.getHeaders().add("Access-Control-Expose-Headers","authorization");
//
//                //将当前请求头中过期的token替换为新的token
//                // 将新的token转发给微服务
//                ServerHttpRequest.Builder requestBuilder = request.mutate();
//                // 先删除，后新增
//                requestBuilder.headers(k -> k.remove("Authorization"));
//                requestBuilder.header("Authorization", token);
//                ServerHttpRequest requestNew = requestBuilder.build();
//                exchange.mutate().request(requestNew).build();
//
//            }
//
//            // 执行到此处说明有token且合法
//        }
//
//        // 放行
//        return chain.filter(exchange);
//    }
//
//    private Mono<Void> goLogin(ServerHttpResponse response) {
//        // 终止请求，返回结果
//        ResponseResult responseResult = new ResponseResult();
//        responseResult.setCode(403);
//        responseResult.setMsg("给老子登录去！！");
//        responseResult.setResultStatus(ResultStatus.NO_LOGIN);
//
//        // 转换数据：转换成byte类型的数组
//        try {
//            byte[] data = new ObjectMapper().writeValueAsString(responseResult).getBytes(StandardCharsets.UTF_8);
//
//            // 将数据进行封装
//            DataBuffer buffer = response.bufferFactory().wrap(data);
//
//            // 设置相应头
//            response.getHeaders().add("Content-Type","application/json;charset=utf-8");
//
//            // 返回数据
//            return response.writeWith(Mono.just(buffer));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private boolean requireAuth(String uri){
//        String[] uris = {"/auth/","/normal","/peak/"};
//
//        for(String value : uris){
//            if (uri.startsWith(value)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // 指定当前过滤器执行的顺序的，数字越小越先执行
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
