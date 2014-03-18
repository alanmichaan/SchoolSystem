package amichaan_lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//java.io.PrintWriter course_string;
//course_string = new java.io.PrintWriter(_file);

public class Department {
	public Queue<Student> student_list = new LinkedList<Student>();
	//public Student [] student_list = new Student [15];
	public Course [] course_list = new Course [12];

	
	public Course[] initCourses(){
		
		//create a new file object
		File _file = new File("C:\\Users\\iris\\workspace\\amichaan_lab03\\Courses.txt");
		
		//create a course list which will be returned
		Course [] course_list1 = new Course[12];
		try{
			
			//create scanner obejct to read file
			Scanner input = new Scanner(_file);
			int i = 0;
			
			//add courses to the course list and set the name (read from file)
			while(input.hasNext()){
				course_list1[i] = new Course(input.next());
				i++;
			}
			input.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
		}
		return course_list1;
	}
	
	
	public Student[] initStudents(){
		//create a new file object
		File _file = new File("C:\\Users\\iris\\workspace\\amichaan_lab03\\Students.txt");

		//create a course list which will be returned
		Student [] student_list1 = new Student[15];
		try{

			//create scanner obejct to read file
			Scanner input = new Scanner(_file);
			int i = 0;

			//add courses to the course list and set the name (read from file)
			while(input.hasNext()){
				String name = input.next();
				int ID = input.nextInt();
				student_list1[i] = new Student(name, ID);
				i++;
			}
			input.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
		}
		return student_list1;
	}

	
	
	//public void setCourseArray( Course [] array){
		//this.course_list = array;
	//}
	
	//public void setStudentArray( Student [] array){
		//this.student_list = array;
	//}
	
	public Department(){ //amichaan_lab03_Student [] students,Course [] course
		//student_list = students;
		//course_list = course; 
	}
}
