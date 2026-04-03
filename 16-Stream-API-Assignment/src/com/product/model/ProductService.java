package com.product.model;
import java.util.*;
import java.util.stream.*;

public class ProductService {
	


	    // 1. Out of stock products
	    public static void outOfStock(List<Product> list) {
	        list.stream()
	            .filter(p -> p.getStock() == 0)
	            .forEach(System.out::println);
	    }

	    // 2. Group by category
	    public static void groupByCategory(List<Product> list) {
	        Map<String, List<Product>> map = list.stream()
	                .collect(Collectors.groupingBy(Product::getCategory));

	        map.forEach((cat, products) -> {
	            System.out.println("Category: " + cat);
	            products.forEach(System.out::println);
	        });
	    }

	    // 3. Total stock value
	    public static double totalStockValue(List<Product> list) {
	        return list.stream()
	                .mapToDouble(p -> p.getPrice() * p.getStock())
	                .sum();
	    }

	    // 4. Highest sold units
	    public static void highestSold(List<Product> list) {
	        list.stream()
	            .max(Comparator.comparingInt(Product::getSoldUnits))
	            .ifPresent(p -> System.out.println("Top Selling: " + p));
	    }

	    // 5. Sort by sold units descending
	    public static void sortBySoldDesc(List<Product> list) {
	        list.stream()
	            .sorted((a, b) -> b.getSoldUnits() - a.getSoldUnits())
	            .forEach(System.out::println);
	    }

	    // 6. Map product name to stock
	    public static void nameToStockMap(List<Product> list) {
	        Map<String, Integer> map = list.stream()
	                .collect(Collectors.toMap(
	                        Product::getName,
	                        Product::getStock
	                ));

	        map.forEach((name, stock) ->
	                System.out.println(name + " -> " + stock));
	    }

	    // 7. Check all products have stock > 0
	    public static boolean allInStock(List<Product> list) {
	        return list.stream()
	                .allMatch(p -> p.getStock() > 0);
	    }
	}

