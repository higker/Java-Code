package com.example.add;

import org.junit.jupiter.api.Test;

public class TestAdd {
	
	@Test
	public void Test01(){
		 Additive add = new Additive(1,2);
		 add.addCompute();
		 System.out.println(add.getSum());
	}
}
