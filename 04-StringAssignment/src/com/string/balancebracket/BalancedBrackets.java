package com.string.balancebracket;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the brackets: ");
		String str = scanner.nextLine();

		System.out.println("Balanced brackets: " + isBalanced(str));
	}

	private static boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {

				stack.push(ch);

			} else if (ch == ')' || ch == '}' || ch == ']') {

				if (stack.isEmpty()) {
					return false;
				}

				char open = stack.pop();

				      if ((ch == ')' && open != '(') || 
						(ch == '}' && open != '{') || 
						(ch == ']' && open != '[')) {
					   return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
