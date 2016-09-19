package PracticeQuestion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ch13.exam09.Student;

public class HashSetExample {
	public static void main(String[] args){
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(3, "조민우"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()){
			Student stuedent = iterator.next();
		}
	}
}
