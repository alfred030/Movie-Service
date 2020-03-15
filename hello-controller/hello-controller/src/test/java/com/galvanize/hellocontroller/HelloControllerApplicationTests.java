package com.galvanize.hellocontroller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloControllerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testHello() {
		HelloController helloController = new HelloController();

		String actual = helloController.sayHello();

		aasertEquals( expected: "Hello World", actual);
	}

}
