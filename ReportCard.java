package amichaan_lab03;

import java.util.HashMap;
import java.util.Map;

public class ReportCard {
		
	ReportCard(){
		
	}
	
	public void generateMarks(Student [] student_list){
		Course current_course = null;
		int total_courses = 0;
		
		//add a list of all current courses to the hash map, and all of its corresponding students
		//you gotta know which courses each student is in, not just which students are in each course
		
		//get the current amount of courses
		//for(int i = 0; i < course_list.length; i++){
		//	if (course_list[i] != null) total_courses++;
		//}
		
		//iterate through the courses
		/*for(int i = 0; i <total_courses; i++){
			
			Student [] current_student_list = course_list[i].list_students;
			int total_students = 0;
			
			//count how many students in that particular course
			for(int j = 0; j< current_student_list.length; j ++){
				if (current_student_list[i] != null) total_students++;
			}
			
			//generate course grades for each student
			for(int j = 0; j< total_students; j ++){
				current_student_list[i]
			}
		
		
	
		
		}*/
		
		
	}
	
	/*for( int i = 0; i<12; i++){
		this.marks_list[i] = 50 + (int)(Math.random() * 50);
	}*/
}
