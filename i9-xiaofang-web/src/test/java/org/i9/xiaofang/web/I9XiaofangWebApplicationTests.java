package org.i9.xiaofang.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class I9XiaofangWebApplicationTests {

	/*@Autowired
	private UserMapper userMapper;*/

	@Test
	public void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
		/*List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);*/
	}

}

