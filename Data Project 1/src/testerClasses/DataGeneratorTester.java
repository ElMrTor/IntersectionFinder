package testerClasses;

import java.util.Random;

import dataGenerator.DataGenerator;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set1P3;
import mySetImplementations.Set2;
import setIntersectionFinders.P1AndP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;

/**
 * 
 * Class that generates random data sets and  prints them to the console to test the DataGeneration.
 *
 */

public class DataGeneratorTester {

	public static void main(String[] args) {
		int totalSize = 2000; 
		int n = 20, m = 10; 
		DataGenerator dg = new DataGenerator(n, m, totalSize);
		dg.generateData(); 
		dg.printSizes();
		dg.printSets();		

	}

}
