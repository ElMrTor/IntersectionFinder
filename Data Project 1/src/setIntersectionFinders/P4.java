package setIntersectionFinders;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set1P3;
import mySetImplementations.Set2;

/**
 * Class that implements the P4 intersection strategy and it can also return the intersecting sets of the data analyzed.
 * 
 * @author Hector E. Montes Martinez
 *
 * @param <E>
 */

public class P4<E> extends AbstractIntersectionFinder {

	ArrayList allElements;
	HashMap<E, Integer> map;
	private static Integer[][][] dataSet;
	
	public P4(String name) {
		super(name);
		map = new HashMap<E, Integer>();
	}

	//Returns the intersecting sets implementing the P4 strategy.
	@Override
	public MySet intersectSets(MySet[] t) {
		allElements = new ArrayList<Integer>();

		
		for(Object element: t[0]) {
			allElements.add(element);
		}
	
		for(Object e: allElements) {
			Integer c = map.getOrDefault(e, 0);
			map.put((E)e, c + 1);
		}
		
		MySet<E> returnSet = (MySet<E>) new Set2<Integer>();
		for(Map.Entry<E, Integer> entry :map.entrySet())
			if(entry.getValue() >= dataSet[0].length) // check
				returnSet.add(entry.getKey());
		
		
		return returnSet;
	}
	
	/**
	 * Arranges the Integer[][][] into a set that can be implemented by P4 strategy.
	 * @param data
	 * @return
	 */
	
	public static MySet[] arrangeDataP3P4(Integer[][][] data) {
		dataSet = data;
		MySet p3p4Sol = new Set1P3<Integer>();
		
		for(int i = 0; i < data[0].length; i++) {
			for(int j = 0; j < data.length; j++) {
				
				for(int k = 0; k<data[j][i].length; k++) {					
						p3p4Sol.add(data[j][i][k]);					
				}
			}
						
		}	
		
		MySet[] setp3p4 = new MySet[1];
		setp3p4[0] = p3p4Sol;
		
		return setp3p4;
		}
	


}
