package cn.com.zs.permissions;

import cn.com.zs.permissions.web.EchoHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


@SpringBootApplication
@ComponentScan(basePackages = "cn.com")
public class ZsPermissionsMasterApplication {


	public static void main(String[] args) {
		SpringApplication.run(ZsPermissionsMasterApplication.class, args);
	}

}
