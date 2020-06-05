package com.mycompany;

import java.util.Arrays;
import java.util.List;

public class Digit {
	
private boolean roman;
private int value;
private String name;
private static List<String> romanList;
private static List<String> romanDecimalList;
static {
	romanList = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
	romanDecimalList = Arrays.asList("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");
}
public Digit() {}

public Digit(String name) {
	
	if(name.matches("[1-9]|10")) {
		roman = false;
		value = Integer.parseInt(name);
	} 
	else if(!romanList.contains(name))
			throw new IllegalArgumentException("Illegal argument");
	else {
		roman = true;
		value = romanList.indexOf(name) + 1;
	}
}
public void setName(int value, boolean roman) {
	this.roman = roman;
	this.value = value;
	if(!roman)
		name = value + "";
	else {
		int decimal = value / 10;
		int rest = value % 10;
		String decimalStr = "";
		String restStr = "";
		if (decimal > 0) 
			decimalStr = romanDecimalList.get(decimal - 1);
		if (rest > 0) 
			restStr = romanList.get(rest - 1);
		String result = decimalStr + restStr;
		if (result.isEmpty())
			result = "0";
		name = result;
		
	}
		
}
public String getName() {
	return name;
}
public int getValue() {
	return value;
}
public boolean isRoman() {
	return roman;
}
}
