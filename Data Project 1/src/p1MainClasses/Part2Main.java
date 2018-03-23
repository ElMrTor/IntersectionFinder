package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import TimeCollection.StrategiesTimeCollection;
import dataGenerator.DataGenerator;
import setIntersectionFinders.P1AndP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;


/**
 * 
 * Class that test all four intersection strategies and records the time of runs with many repetitions.
 * 
 * @author Héctor E. Montes Martinez
 *
 */


public class Part2Main {
	
	private static int n = 10; //Telephone companies
	private static int m = 50; //Crime events
	private static int iS = 1000; //Initial size
	private static int fS = 50000; //Final size
	private static int sInc = 1000; //Size incremental
	private static int nRep = 200; //Number of repetitions
	private static ArrayList<StrategiesTimeCollection> resultsPerStrategy;

	public static void main(String[] args) {

		
		if(args.length >= 1) {
			n = Integer.parseInt(args[0]);
		}
		if(args.length >= 2) {
			m = Integer.parseInt(args[1]);
		}
		if(args.length >= 3) {			
			iS = Integer.parseInt(args[2]);
		}
		if(args.length >= 4) {			
			fS = Integer.parseInt(args[3]);
		}
		if(args.length >= 5) {			
			sInc = Integer.parseInt(args[4]);
		}
		if(args.length == 6) {			
			nRep = Integer.parseInt(args[5]);
		}
		
		
		
		
		resultsPerStrategy = new ArrayList<>();
		resultsPerStrategy.add(new StrategiesTimeCollection(new P1AndP2<Integer>("P1")));
		resultsPerStrategy.add(new StrategiesTimeCollection(new P1AndP2<Integer>("P2")));
		resultsPerStrategy.add(new StrategiesTimeCollection(new P3<Integer>("P3")));
		resultsPerStrategy.add(new StrategiesTimeCollection(new P4<Integer>("P4")));
		
		for(int size = iS; size<fS; size += sInc) {
			for(StrategiesTimeCollection<Integer> strategy: resultsPerStrategy) {
				strategy.resetSum();
			}
			
			for(int r = 0; r < nRep; r++) {
				DataGenerator dG = new DataGenerator(n, m, size);
				Integer[][][] dataset = (Integer[][][]) dG.generateData();
				
				
				for(StrategiesTimeCollection<Integer> strategy: resultsPerStrategy) {
					long startTime = System.nanoTime();
					strategy.runTrial(dataset);
					long endTime = System.nanoTime();
					
					int estimatedTime = (int) (endTime - startTime);
					strategy.incSum(estimatedTime);
				}				
			}
			for(StrategiesTimeCollection<Integer> strategy: resultsPerStrategy) {
				strategy.add(new AbstractMap.SimpleEntry<Integer, Float>(size, (strategy.getSum()/(float)(nRep))));
			}
		}
		
		try {
			saveResults();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void saveResults() throws FileNotFoundException { 
		
		PrintStream out = new PrintStream(new File("experimentalResults", "allResults.txt"));
		out.print("Size");
		for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy) 
			out.print("\t" + trc.getStrategyName()); 
		out.println();

		int numberOfExperiments = resultsPerStrategy.get(0).size(); 
		for (int i=0; i<numberOfExperiments; i++) {
			out.print(((SimpleEntry<Integer, Float>) resultsPerStrategy.get(0).get(i)).getKey());
			for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy)
				out.print("\t" + trc.get(i).getValue());
			out.println(); 
		}
			
		out.close();
		
	}
	

}
