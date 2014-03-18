package amichaan_lab03;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Course {
	
	//data fields
		public String m_course_name;
		public Student [] list_students; 
		public Queue<Student> waiting_list;

		public void addStudent(Student student){
			if (!this.isFull())
				for(int i = 0; i< list_students.length; i++){
					if (list_students[i] != null){
						list_students[i] = student;
					}
				}
		}
		
		public int size(){
			int returnVal = 0;
			for(int i = 0; i<this.list_students.length; i++ ){
				if (this.list_students[i] != null) returnVal++;
			}
			return returnVal;
		}
		
		public boolean isFull(){
			return (this.size() == list_students.length);
		}
		//constructor
		public Course(String course_name ){
			m_course_name = course_name;
			list_students = new Student[5];
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
