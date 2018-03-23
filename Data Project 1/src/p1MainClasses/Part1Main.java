package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set1P3;
import mySetImplementations.Set2;
import setIntersectionFinders.P1AndP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;

public class Part1Main {

	static Object allData[][][];
	private static int n;
	private static int m;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		DataReader dR = new DataReader();		
		allData = dR.readDataFiles();
		
		Scanner parameters = new Scanner(new File("inputFiles", "parameters.txt")); 
		
		n = parameters.nextInt();
		m = parameters.nextInt();
		parameters.close();		
		
		//Manages arguments
		if((args.length >= 0 && args.length <= 4)|| args == null) {
			if(args.length == 0) {
				doSolutionP1();
				doSolutionP2();
				doSolutionP3();
				doSolutionP4();
			}
			else if(Integer.parseInt(args[0]) == 1) {
				doSolutionP1();
			}
			else if(Integer.parseInt(args[0]) == 2) {
				doSolutionP2();
			}
			else if(Integer.parseInt(args[0]) == 3) {
				doSolutionP3();
			}
			else if(Integer.parseInt(args[0]) == 4) {
				doSolutionP4();
			}
			
		}		
		
	}
	
	
	
	
	public static void doSolutionP1() {

		P1AndP2 comparator = new P1AndP2("P1");
		System.out.println("Final Set by " + comparator.getName() + ": " +comparator.intersectSets(comparator.generateSets((Integer[][][]) allData)));
	}
	
	
	public static void doSolutionP2() {
			
		P1AndP2 comparator = new P1AndP2("P2");
		System.out.println("Final Set by " + comparator.getName() + ": " + comparator.intersectSets(comparator.generateSets((Integer[][][]) allData)));
		
	}
	
	
	
	public static void doSolutionP3() {
	
		P3 solutionP3 = new P3("P3");
		System.out.println("Final Set by " + solutionP3.getName() + ": " + solutionP3.intersectSets(solutionP3.arrangeDataP3P4((Integer[][][]) allData)));

		
		
	}
	public static void doSolutionP4() {
		
		P4 solutionP4 = new P4<>("P4");
		System.out.println("Final Set by " + solutionP4.getName() + ": " + solutionP4.intersectSets(solutionP4.arrangeDataP3P4((Integer[][][]) allData)));
		
		
		
	}
	
	
	
	
	
}
