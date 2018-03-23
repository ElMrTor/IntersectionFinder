package setIntersectionFinders;

import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;


/**
 * Class that arranges the data files as an Integer[][][] and then transfers it to an array of Mysets
 * so then it can be processed by the intersection finder according to the name of the method chosen.
 * 
 * 
 * @author Héctor E. Montes Martinez
 *
 * @param <E>
 */

public class P1AndP2<E> extends AbstractIntersectionFinder {

	public P1AndP2(String name) {
		super(name);
	}

	/**
	 * Method that takes an Array of mysets and gets all the intersections according to the method chosen.
	 * @param Myset[] Array of Mysets
	 */
	
	@Override
	public MySet intersectSets(MySet[] t) {	
		
		if(t.length == 0) {return null;}
		
		else {
			Iterator ite = t[0].iterator();	
			
			while(ite.hasNext()) {
				Object value = ite.next();
				for(MySet test :t) {
					if(!test.contains(value)) {
						ite.remove();
						break;
					}
				}
			}
			return t[0];
		}		
		

	}
	
	/**
	 * Method that takes all the data and returns it in an array of Mysets so that it can be later analyzed.
	 * 
	 * @param data Integer[][][]  The data that is going to be analyzed.
	 * @return Myset[] An array of mysets.
 	 */
	
	public MySet[] generateSets(Integer[][][] data) {
		
		if(getName().equals("P1")) {
			MySet[] verify = new MySet[data[0].length];
			for(int i = 0; i < data[0].length; i++) {
				MySet set = new Set1<Integer>();
				for(int j = 0; j < data.length; j++) {
							
					for(int k = 0; k<data[j][i].length; k++) {
						if(!set.contains(data[j][i][k])) {
							set.add(data[j][i][k]);
								}
							}
						}
					verify[i] = set;	
				}					
			return verify;
		}
		
		if(getName().equals("P2")){
			MySet[] verify = new MySet[data[0].length];
			for(int i = 0; i < data[0].length; i++) {
				MySet set = new Set2<Integer>();
				for(int j = 0; j < data.length; j++) {							
					for(int k = 0; k<data[j][i].length; k++) {
						if(!set.contains(data[j][i][k])) {
							set.add(data[j][i][k]);
								}
							}
						}
					verify[i] = set;			
				}					
			return verify;			
		}		
		else 
			return null;		
	}
	


}
