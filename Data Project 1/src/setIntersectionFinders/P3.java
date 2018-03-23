package setIntersectionFinders;

import java.util.ArrayList;

import interfaces.MySet;
import mySetImplementations.Set1P3;
import mySetImplementations.Set2;

/**
 * 
 * Class that arranges the data so that the P3 strategy can be implemented and get the intersecting sets by this strategy.
 * 
 * @author Hector E. Montes Martinez
 *
 * @param <E>
 */

public class P3<E> extends AbstractIntersectionFinder {

	ArrayList allElements;
	private static Integer[][][] dataSet;
	
	public P3(String name) {
		super(name);
		
	}

	@Override
	public MySet intersectSets(MySet[] t) {
		allElements = new ArrayList<Integer>();
		for(Object element: t[0]) {
			allElements.add(element);
		}
		
		allElements.sort(null);
		MySet newSet = new Set2<Integer>();
		
		Object e = allElements.get(0);
		int c = 1;
		
		for(int i = 1; i < allElements.size(); i++) {
			if(allElements.get(i).equals(e))
				c++;
			else {
				if(c >= dataSet[0].length)
					newSet.add(e);
				e = allElements.get(i);
				c = 1;
			}
		}
		
		if(c >= dataSet[0].length)
			newSet.add(allElements.get(allElements.size() - 1));
		
		
		return newSet;
	}
	
	
	//Arranges the Integer[][][] so that it can be analyzed by the P3 Strategy
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
