package ch15.exam06;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args){
		TreeSet<Person> treeSet1 = new TreeSet<>();
		treeSet1.add(new Person("홍길동", 25));
		treeSet1.add(new Person("감자바", 30));
		treeSet1.add(new Person("박동수", 21));
		
		TreeSet<Fruit> treeSet2 = new TreeSet<>(new FruitComparator());
		treeSet2.add(new Fruit("사과", 3000));
		treeSet2.add(new Fruit("복숭아", 5000));
		treeSet2.add(new Fruit("포도", 2500));
		
		NavigableSet<Person> ns1 = treeSet1.descendingSet();
		for(Person p : ns1){
			System.out.println(p);
		}
		System.out.println();
		
		NavigableSet<Fruit> ns2 = treeSet2.descendingSet();
		for(Fruit f : ns2){
			System.out.println(f);
		}
		System.out.println();
	}
}
