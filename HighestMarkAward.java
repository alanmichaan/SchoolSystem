package amichaan_lab03;

import java.util.Vector;

public class HighestMarkAward extends Scholarship {

	@Override
	double getWinner(Vector<Student> students_in_courses) {
		
		java.util.Iterator<Student> iter = students_in_courses.iterator();		
		double highest_mark = 0d;
		double individual_high = 0d;
				
		//while there are no more students in courses
		while(iter.hasNext()){
						
			//grab the first student
			Student current_student = iter.next();
			
			//grab the student's highest mark
			individual_high = current_student.highestMark();

			
			if (individual_high > highest_mark){
				highest_mark = individual_high;
			}
		}	
		
		return highest_mark;
	}
}
