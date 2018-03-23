package TimeCollection;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import setIntersectionFinders.AbstractIntersectionFinder;
import setIntersectionFinders.P1AndP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;

/**
 * Class is based on the StrategiesTimeCollection from the lab of sorting algorithms.
 * It is modified so that it can run with the four intersection types.
 * 
 * @author Hector E. Montes Martinez
 *
 * @param <Integer>
 */

public class StrategiesTimeCollection<Integer>  extends ArrayList<Map.Entry<Integer, Float>>{

	private AbstractIntersectionFinder strategy;	
	private int sum;
	
	public StrategiesTimeCollection(AbstractIntersectionFinder<Integer> finder) {
		strategy = finder;		
	}
	
	
	
	public void runTrial(Integer[][][] data) {
		if(strategy instanceof P1AndP2) {
			P1AndP2 strat = (P1AndP2) strategy;
			strat.intersectSets(strat.generateSets((java.lang.Integer[][][]) data));
		}
		if(strategy instanceof P3) {
			P3 strat = (P3) strategy;
			strat.intersectSets(strat.arrangeDataP3P4((java.lang.Integer[][][]) data));
		}
		if(strategy instanceof P4) {
			P4 strat = (P4) strategy;
			strat.intersectSets(strat.arrangeDataP3P4((java.lang.Integer[][][]) data));
			
		}
	}
	
	public void resetSum() {
		sum = 0;
	}
	
	public void incSum(int toSum) {
		this.sum += toSum;
	}
	
	public int getSum() {
		return this.sum;
	}
	
	public String getStrategyName() {
		return strategy.getName();
	}
	
}
