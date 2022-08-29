package io.matoshri.market;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketApplicationTests {

	@Test
	void contextLoads() {
		boolean b = true;
		assertThat(b).isTrue();
	}

}
