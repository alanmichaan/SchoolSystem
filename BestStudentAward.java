package amichaan_lab03;

import java.util.Vector;

public class BestStudentAward extends Scholarship{
	
	@Override
	double getWinner(Vector<Student> students_in_courses) {
		java.util.Iterator<Student> iter = students_in_courses.iterator();		
		double highest_average = 0d;
		double current_average = 0d;
		//while there are no more students in courses
		while(iter.hasNext()){
			
			//grab the first student
			Student current_student = iter.next();
			current_average = current_student.average;
			if (current_average > highest_average){
				highest_average = current_student.average;
			}
		}
		return highest_average;
	}
}
