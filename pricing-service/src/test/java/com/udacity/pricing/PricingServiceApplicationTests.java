package com.udacity.pricing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
@AutoConfigureMockMvc 
public class PricingServiceApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testrestTemplate; 


	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getVehiclePrice() {
		ResponseEntity<String> response =
				this.testrestTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=1", String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
