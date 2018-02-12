package cn.com.zs.permissions.web;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 标题:
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2018

 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-20:10
 */
@Component
public class EchoHandler {

    public Mono<ServerResponse> echo(ServerRequest request){
        return ServerResponse.ok().body(request.bodyToMono(String.class),String.class);
    }
}
