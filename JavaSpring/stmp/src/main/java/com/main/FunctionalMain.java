package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalMain {

	static void optional(){
	    String[] str = new String[10];  
	    Optional<String> checkNull = Optional.ofNullable(str[5]);  
	    if(checkNull.isPresent()){  // check for value is present or not  
	        String lowercaseString = str[5].toLowerCase();  
	        System.out.println(lowercaseString);  
	    }else  
	        System.out.println("string value is not present");

        checkNull.ifPresent(System.out::println); 
	}
	
	public static void main(String[] args) {
//		optional();
//		predicateInterface();
//		consumerInterface();
		supplierInterface();
	}
	
	static void predicateInterface() {  
	   Predicate<Integer> pr = a -> (a > 18); // Creating predicate  
	   System.out.println(pr.test(10));    // Calling Predicate method 
	}
	
	static void consumerInterface() {
		Consumer<Integer> show = a -> {
			System.out.print(a + "::");
		};
		show.accept(10);
		
		List<Integer> ls = new ArrayList<>();
		ls.add(12);
		ls.add(15);
		
		Consumer<List<Integer>> modify = lst -> {
			for(int i=0; i<lst.size(); i++) {
				lst.set(i, lst.get(i)*2);
			}
		};
		
		Consumer<List<Integer>> display = lst -> lst.stream().forEach(show);
		
		modify.andThen(display).accept(ls);
		
	}
	
	static void supplierInterface() {
		Supplier<Double> randomValue = () -> Math.random();
		
		System.out.println(randomValue.get());
		
	}

}
