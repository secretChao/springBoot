package com.test;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("000");
		
		String[] s1 = list.toArray(new String[0]);
		for(String s : s1) {
			System.out.println(s);
		}
		
		Object[] s2 = list.toArray();
		for(Object s : s2) {
			System.out.println((String)s);
		}
		
		// ClassCastException 
		String[] s3 = (String[]) list.toArray();
		for(String s : s3) {
			System.out.println(s);
		}
	}
}
