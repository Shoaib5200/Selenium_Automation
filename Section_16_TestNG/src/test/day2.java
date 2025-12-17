package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@Test
	public void day2_secondTest() {
		System.out.println("Class (Day 2) - Hello World 1st test");
	}
	
	@BeforeTest
	public void prerequise() {
		System.out.println("Class (Day 2) - Hello World 1st test | I will execute first");
	}
}
