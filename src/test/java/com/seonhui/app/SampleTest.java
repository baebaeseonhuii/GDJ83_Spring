package com.seonhui.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends DefaultTest {

	@AfterClass
	public static void afterAll() {
		System.out.println("====after All====");
	}

	@BeforeClass
	public static void beforeAll() {
		System.out.println("====before All====");
	}

	@Before
	public void before() {
		System.out.println("----before----");
	}

	@After
	public void after() {
		System.out.println("----after----");
	}

	@Test
	public void t1() {
		System.out.println("t1 method");
		fail("--- t1 fail ---");
	}

	@Test
	public void t2() {
		System.out.println("t2 method");
		assertEquals(0, 0);
	}

}
