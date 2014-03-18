package studentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//java.io.PrintWriter course_string;
//course_string = new java.io.PrintWriter(_file);

public class Department {
	public Queue<Student> student_list = new LinkedList<Student>();
	//public amichaan_lab03_Student [] student_list = new amichaan_lab03_Student [15];
	
	public Queue<Course> course_list = new LinkedList<Course>();
	//public Course [] course_list = new Course [12];

	
	public Queue<Course> initCourses(){
		
		//create a new file object
		File _file = new File("C:\\Users\\iris\\workspace\\amichaan_lab03\\Courses.txt");
		
		//create a course list which will be returned
		Queue<Course> course_list2 = new LinkedList<Course>();
		try{
			
			//create scanner object to read file
			Scanner input = new Scanner(_file);
			int i = 0;
			
			//add courses to the course list and set the name (read from file)
			while(input.hasNext()){
				course_list2.add(new Course(input.next()));
				i++;
			}
			input.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
		}
		return course_list2;
	}
	
	
	public Queue<Student> initStudents(){
		//create a new file object
		File _file = new File("C:\\Users\\iris\\workspace\\amichaan_lab03\\Students.txt");

		//create a course list which will be returned
		Queue<Student> student_list2 = new LinkedList<Student>();
		try{

			//create scanner object to read file
			Scanner input = new Scanner(_file);

			//add courses to the course list and set the name (read from file)
			while(input.hasNext()){
				String name = input.next();
				int ID = input.nextInt();
				student_list2.add(new Student(name, ID));
			}
			input.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
		}
		return student_list2;
	}

	
	
	public void setCourseArray(Queue<Course> _course_list){
		this.course_list = _course_list;
	}
	
	public void setStudentArray( Queue<Student> _student_list){
		this.student_list = _student_list;
	}
	
	public Department(){}
}
