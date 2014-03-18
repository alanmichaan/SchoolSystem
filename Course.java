package studentsystem;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class Course {
	
	//data fields
		public String m_course_name;
		//public Student [] list_students; 
		public Vector<Student> list_students; 
		public Queue<Student> waiting_list;


	
		//constructor
		public Course(String course_name ){
			m_course_name = course_name;
			list_students = new Vector<Student>();;
			waiting_list = new LinkedList<Student>();
		}
		
		//getters and setters
		public String getName() {
			return m_course_name;
		}


		public void setName(String m_course_name) {
			this.m_course_name = m_course_name;
		}

	
}
