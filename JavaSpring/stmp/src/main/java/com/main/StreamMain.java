package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.entities.Product;

public class StreamMain {

	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		Stream<Product> stream = productsList.stream();
		System.out.println(stream);

		Stream<Product> filteredStream = stream.filter(p -> {
//			p.setId(101);
			System.out.println("filter " + p.getId());
//			productsList.add(new Product(6, "Mac Laptop", 34000f));
			return p.getPrice() >= 30000;
		});
		productsList.add(new Product(6, "Mac Laptop", 34000f));
		System.out.println(filteredStream);
		
		Map<Integer, String> productMap = filteredStream.collect(Collectors.toMap(p->p.getId(), p->p.getName()));
		System.out.println(productMap);
		
//		Stream<String> stream1 = filteredStream.map(p -> {
//			System.out.println(p.getId());
////			p.setName("Ksolves");
//			if (p.getPrice() > 30000) {
//				return p.getName();
//			} else {
//				return p.getId()+"";
//			}
//		});
//		System.out.println(stream1);
//
//		List<String> productPriceList2 = stream1.collect(Collectors.toList());
//		System.out.println(productPriceList2);
		
//		System.out.println(productsList);
//		for (Product p : productsList) {
////        	p.setName("Vikas");
//		}
//		System.out.println(productsList);
//		streamIterate();
	}

	public static void streamIterate() {
		Stream.iterate(1, element -> {
			System.out.println("e " + element);
			return element + 1;
		}).filter(element -> element % 5 == 0).limit(5).forEach(System.out::println);
	}

}
