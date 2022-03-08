package com.hit.algorithm;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StringMatchingAlgorithmTest {
	
	public static void main(String[] args) {
		Result result=JUnitCore.runClasses(KMP_Algorithm.class);
		
		for (Failure failure : result.getFailures()) {
		System.out.println(failure.toString());	
		}
		System.out.println("Result of KMP == "+result.wasSuccessful());

		result=JUnitCore.runClasses(Rabin_Karp_Algorithm.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());	
		}
		System.out.println("Result of Rabin_Karp == "+result.wasSuccessful());
		
		result=JUnitCore.runClasses(KMP_Algorithm.class);
	}
}
