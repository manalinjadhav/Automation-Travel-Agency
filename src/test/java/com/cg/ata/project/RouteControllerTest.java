package com.cg.ata.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ata.project.controller.RouteController;

@SpringBootTest
public class RouteControllerTest {

	@Autowired
	RouteController rootController;

	@Test
	public void testGetRouteById() {
		assertEquals(2, rootController.viewRouteById(2).getBody().getRouteId());

	}

	@Test
	@Disabled
	public void testGetRouteById2() {
		assertNotEquals(3, rootController.viewRouteById(2));
	}

}