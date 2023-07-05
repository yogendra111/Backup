package com.demoboot.conditional;

public enum Profile {
	DEV("dev"),
	TEST("test");
	
	public final String label;

    private Profile(String label) {
        this.label = label;
    }
}
