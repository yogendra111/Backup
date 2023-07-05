package com.demoboot.conditional;

//@Component
//@ConditionOnProfile("dev")
public class ForConditionDev implements ConditionProfile {
	
	@Override
	public String welcome() {
		return "Welcome Dev!";
	}

}
