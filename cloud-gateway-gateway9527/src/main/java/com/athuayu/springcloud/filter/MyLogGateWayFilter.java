package com.athuayu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/*
 *@author Leelay
 *@date 2020/10/2813:58
 *@Description:
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******come in MyLogGateWayFilter: " + new Date());
        //表示请求的参数里面必须要有uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("用户名为null，非法用户，┭┮﹏┭┮");
            //响应一个状态码表示不被接受的
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //返回完整的响应
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);//表示返回给下一个过滤器验证
    }

    @Override
    public int getOrder() {
        return 0;//数字越小优先级越高
    }
}

