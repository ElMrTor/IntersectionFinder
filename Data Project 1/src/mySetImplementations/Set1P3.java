package mySetImplementations;

import interfaces.MySet;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Class is the same as Set1 with the only exception that the add method can have duplicates of values unlike the original Set1.
 * 
 * @author Héctor E. Montes Martinez
 *
 * @param <E>
 */

public class Set1P3<E> extends AbstractMySet<E> {
	   private ArrayList<E> elements; 
	   public Set1P3() { 
	       elements = new ArrayList<>(); 
	   }
	   public int size() { 
		   return elements.size(); 
	   } 
	   public boolean contains(E e) { 
	      int i = find(e);    // sequential search for e in list elements
	      return i >= 0; 
	   } 
	   public void add(E e) { 	     
	         elements.add(e); 
	   } 
	   public void remove(E e) { 
	      int i = find(e); 
	      if (i == -1) return; 
	      int last = elements.size() - 1;
	      if (i < last) 
	         elements.set(i, elements.get(last)); 
	      elements.remove(last); 
	   } 
	   private int find(E e) { 
	      for (int i=0; i<elements.size(); i++) 
	          if (elements.get(i).equals(e))
	             return i;     // e found at position i of list elements
	      return -1;   // e is not found in the set
	   } 
	   public Iterator<E> iterator() { 
	      return elements.iterator(); 
	   } 
	   
	   public Object clone() throws CloneNotSupportedException { 
		   Set1P3<E> setClone = new Set1P3<>(); 
		   setClone.elements = (ArrayList<E>) this.elements.clone(); 
		   return setClone; 
	   }

}
