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
		ArrayList<MySet> setList = new ArrayList<MySet>();
		
		//Arranges the data to be analyzed by P1AndP2 with Set1
		for(int i = 0; i < m; i++) {
			MySet set = new Set1<>();
			for(int j = 0; j < n; j++) {
						
				for(int k = 0; k<allData[j][i].length; k++) {
					if(!set.contains(allData[j][i][k])) {
						set.add(allData[j][i][k]);
							}
						}
					}
				setList.add(set);			
			}
				
			//Para set1 p1
		P1AndP2 comparator = new P1AndP2("P1");

		MySet[] setsToVerify = new MySet[m];				
		setList.toArray(setsToVerify);
		MySet returnSet = comparator.intersectSets(setsToVerify);
			
		System.out.println("Final Set By " + comparator.getName() + ": " + returnSet.toString());
				
	}
	
	
	public static void doSolutionP2() {
		ArrayList<MySet> setList = new ArrayList<MySet>();
		
		//another set set2
		for(int i = 0; i < m; i++) {
			MySet set = new Set2<>();
			for(int j = 0; j < n; j++) {
						
				for(int k = 0; k<allData[j][i].length; k++) {
					if(!set.contains(allData[j][i][k])) {
						set.add(allData[j][i][k]);
							}
						}
					}
				setList.add(set);			
			}
		
		MySet[] returnSet = new MySet[m];
		setList.toArray(returnSet);
				
				
		P1AndP2 comparator = new P1AndP2("P2");
		MySet solution = comparator.intersectSets(returnSet);
		System.out.println("Final Set By " + comparator.getName() + ": " + solution.toString());			
		
	}
	
	
	
	public static void doSolutionP3() {
	
		P3 solutionP3 = new P3("P3");
		MySet solution = solutionP3.intersectSets(arrangeDataP3P4());
		System.out.println("Final Set By " + solutionP3.getName() + ": " + solution.toString());		
		
		
		
	}
	public static void doSolutionP4() {
		
		P4 solutionP4 = new P4<>("P4");
		MySet solution = solutionP4.intersectSets(arrangeDataP3P4());
		System.out.println("Final Set By " + solutionP4.getName() + ": " + solution.toString());		
		
		
		
	}
	
	public static MySet[] arrangeDataP3P4() {
		
		MySet p3p4Sol = new Set1P3<>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				for(int k = 0; k<allData[j][i].length; k++) {					
						p3p4Sol.add(allData[j][i][k]);					
				}
			}						
		}	
		
		MySet[] setp3p4 = new MySet[1];
		setp3p4[0] = p3p4Sol;
		
		return setp3p4;
		}
	
	
	
	
}
