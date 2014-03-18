package amichaan_lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Department {
	public Student [] student_list = new Student [10];
	public Course [] course_list = new Course [10];

	public void initCourses(){
		File _file = new File("C:\\Users\\iris\\workspace\\amichaan_lab03\\Courses.txt");
		//java.io.PrintWriter course_string;
		
		try{
			Scanner input = new Scanner(_file);
			int i = 0;
			while(input.hasNext())
				course_list[i].setName(input.next()); 
				System.out.println(input.next());
			
			//course_string = new java.io.PrintWriter(_file);
			input.close();
			i++;
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
			System.exit(0);		
		}
	}
	
	
	
	
	public Department(Student [] students, Course [] course){
		student_list = students;
		course_list = course; 
	}


}
