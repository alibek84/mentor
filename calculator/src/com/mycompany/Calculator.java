package com.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String expression = br.readLine();
		try {
			String[] numbers = expression.split("[+\\-*/]");
			if(numbers.length != 2)
				throw new IllegalArgumentException("Wrong number of arguments");
			String operator = expression.substring(numbers[0].length(), numbers[0].length() + 1);
			Digit operand1 = new Digit(numbers[0]);
			Digit operand2 = new Digit(numbers[1]);
			if (operand1.isRoman() != operand2.isRoman())
				throw new IllegalArgumentException("Arguments must be both roman or both arabic digits");
			Digit result = new Digit();
			switch(operator) {
			case "+":
				result.setName(operand1.getValue() + operand2.getValue(), operand1.isRoman());
				break;
			case "-":
				result.setName(operand1.getValue() - operand2.getValue(), operand1.isRoman());
				break;
			case "/":
				result.setName(operand1.getValue() / operand2.getValue(), operand1.isRoman());
				break;
			case "*":
				result.setName(operand1.getValue() * operand2.getValue(), operand1.isRoman());
				break;
			}
			System.out.println(result.getName());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
