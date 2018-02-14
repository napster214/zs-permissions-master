package cn.com.zs.permissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "cn.com")
public class ZsPermissionsMasterApplication {


	public static void main(String[] args) {
		SpringApplication.run(ZsPermissionsMasterApplication.class, args);
	}

}
