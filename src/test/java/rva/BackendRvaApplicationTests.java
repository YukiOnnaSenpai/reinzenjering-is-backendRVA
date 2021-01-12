package rva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendRvaApplicationTests {

	@Test
	public void contextLoads() {
		String fillingTest = "some";
		String fillingCase = "string";
		assertEquals(fillingTest, fillingCase);
		assertNull(fillingCase);
	}

}
