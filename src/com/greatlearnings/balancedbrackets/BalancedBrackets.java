package com.greatlearnings.balancedbrackets;

import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets {


	public static boolean isBalancedBracket(String inputStr) {

		Stack<Character> stack  = new Stack<Character>();
		int i=0;
		char chr = 0;

		while(i<inputStr.length()) {

			chr = inputStr.charAt(i);
			if(chr == '[' || chr == '(' || chr == '{' ) {     
				stack.push(chr);
				i++;
				continue;
			} 

			if(!stack.isEmpty()) {
				if(chr == ']') {
					if(stack.pop() != '[') 	
						return false;

				} else if(chr == ')') {
					if(stack.pop() != '(') 	
						return false;

				} else if(chr == '}') {
					if(stack.pop() != '{') 	
						return false;
				}
			}
			else if(stack.isEmpty() && (chr == '}' || chr == ')' || chr == ']')) {
				return false;
			}
			i++;
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the brackets expression to evaluate : ");
		String inputStr = sc.nextLine();

		boolean isBalanced = isBalancedBracket(inputStr);

		if (isBalanced) { 
			System.out.println("The entered String has Balanced Brackets");
		}
		else{
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

		sc.close();
	}
}