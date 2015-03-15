package de.schuelkeonline.masterdata.app.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {

	
	@Test
	public void test(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("test1234");
		System.out.print(encoded);
	}
	

	
	
}
