package com.stream.skip;

import java.util.Arrays;
import java.util.List;

public class ListWords {
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("cat","Dog","Elephant","tiger","Lion","Hen","Donkey");
		
		words.stream().filter(w->w.length() > 3)
					  .skip(3)
					  .forEach(System.out::println);
		
		
	}

}
