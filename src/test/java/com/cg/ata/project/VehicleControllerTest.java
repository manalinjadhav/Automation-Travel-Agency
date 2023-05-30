package com.cg.ata.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ata.project.controller.VehicleController;

@SpringBootTest
public class VehicleControllerTest {

	@Autowired
	VehicleController vehController;

	@Test
	public void testGetVehicleById() {
		assertEquals(1, vehController.viewVehicleById(1).getBody().getVehId());

	}

	@Test
	//@Disabled
	public void testGetVehicleById2() {
		assertNotEquals(2, vehController.viewVehicleById(1));
	}
}
