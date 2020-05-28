package com.example.add;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	public void Test01(){
		util.writer(util.PATH, "Hello \r\n");
	}
}
