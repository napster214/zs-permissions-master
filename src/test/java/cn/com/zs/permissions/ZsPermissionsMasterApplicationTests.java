package cn.com.zs.permissions;

import cn.com.zs.permissions.utils.GsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ZsPermissionsMasterApplicationTests {

	@Test
	public void contextLoads() {
	}




	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	static class User{
		private String userName;

		private String password;
	}

}
