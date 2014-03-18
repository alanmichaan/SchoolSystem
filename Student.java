package amichaan_lab03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

public class Student {
	public String m_name;
	public int m_id;
	public Vector<Course> courses;
	public Vector<Integer[]> grades; 
	public double average;

	//constructor that takes two parameters
	Student(String name, int id) {
		this.m_name = name;
		this.m_id = id;
		grades = new Vector<Integer[]>();
		courses = new Vector<Course>();
	}

	public String getName() {
		return m_name;
	}
	
	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public void setAverage() {
		
		//sum up the grades of every course the student is in and get avg
		java.util.Iterator<Integer[]> iter = grades.iterator();		
		
		//while there are no more students in courses
		while(iter.hasNext()){
			
			//grab the next student student
			Integer[] current_grades_array = iter.next();
			average += (double) (current_grades_array[0] + current_grades_array[1] + current_grades_array[2] + current_grades_array[3]);
		}
		
		average = average /(grades.size()*4);
		
	}
	
	public double highestMark() {
		
		//create an iterator 
		java.util.Iterator<Integer[]> iter = grades.iterator();		
		
		//variable which stores the highest mark
		double highest_mark = 0;
		
		//while there are no more students in courses
		while(iter.hasNext()){
			
			//grab the next student student
			Integer[] current_grades_array = iter.next();
			
			//find the highest mark
			for(int i = 0; i <4; i ++){
				if((double) current_grades_array[i]> highest_mark) highest_mark = current_grades_array[i];
			}
		}
		return highest_mark;
	}
	
	public double getAverage() {
		return average;
	}
	
	
	public int getId() {
		return m_id;
	}

	public void setId(int m_id) {
		this.m_id = m_id;
	}
	
}
