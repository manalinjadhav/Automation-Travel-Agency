package com.cg.ata.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ata.project.controller.DriverController;

@SpringBootTest
public class DriverControllerTest {

	@Autowired
	DriverController driController;

	@Test
	public void testGetRouteById() {
		assertEquals(1, driController.viewDriverById(1).getBody().getDriverId());

	}

	@Test
	// @Disabled
	public void testGetRouteById2() {
		assertNotEquals(1, driController.viewDriverById(2));
	}

}