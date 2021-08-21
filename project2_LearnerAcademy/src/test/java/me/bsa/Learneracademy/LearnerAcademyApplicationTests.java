package me.bsa.Learneracademy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class LearnerAcademyApplicationTests {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println(encoder.encode("1234"));
	}
	@Test
	void contextLoads() {
	}

}
