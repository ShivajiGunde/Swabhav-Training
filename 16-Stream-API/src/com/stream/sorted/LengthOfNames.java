package com.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfNames {
	
	public static void main(String[] args) {
		
		
		List<String> names = Arrays.asList("Mahesh","Mahi","Aman","Balaji","Ram","Jay","Mangesh","A");
	
		List<String> nameSort = names.stream()
									 .sorted(Comparator.comparing(s->s.length()))
									 .collect(Collectors.toList());

		System.out.println("Length of names sort: "+nameSort);
	}

}
