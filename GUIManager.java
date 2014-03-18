package studentsystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.Iterator;


public class GUIManager implements ActionListener{
	
	static Button a_option = new Button ("Print List of All Students");
	static Button b_option = new Button ("Print List of Courses");
	static Button c_option = new Button ("Add a Student to a Course");
	static Button d_option = new Button ("Drop a Student From a Course");
	static Button e_option = new Button ("Print a List of Students in a Course");
	static Button f_option = new Button ("Exit");
	static Button g_option = new Button ("Award Scholarship");
	static Button h_option = new Button ("Generate Report Card");
	static Button i_option = new Button ("Show waiting list");
	static Button j_option = new Button ("Validate Files");
	static Button k_option = new Button ("Shuffle");
	static Button l_option = new Button ("Calculate Letter Grade");


	
	static Button ok = new Button("OK");
	
	static Department d1 = new Department();
	static Queue<Student> student_list = new LinkedList<Student>();
	static Queue<Course> course_list = new LinkedList<Course>();
	
	
	static JFrame main_frame = new JFrame("Course Manager");
	static Vector<Student> students_in_courses = new Vector<Student>(); 


	public static void displayMenu(){
		
		main_frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		main_frame.setSize(600, 400);
		main_frame.setLocation(400, 100);
		main_frame.setVisible(true);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//add them to the frame
		main_frame.add(a_option);
		main_frame.add(b_option);
		main_frame.add(c_option);
		main_frame.add(d_option);
		main_frame.add(e_option);
		main_frame.add(g_option);
		main_frame.add(h_option);
		main_frame.add(i_option);
		main_frame.add(j_option);
		main_frame.add(k_option);
		main_frame.add(l_option);
		main_frame.add(f_option);
		
		
		a_option.setName("Print List of All Students");
		b_option.setName("Print List of Courses");
		c_option.setName("Add a Student to a Course");
		d_option.setName("Drop a Student From a Course");
		e_option.setName("Print a List of Students in a Course");
		f_option.setName("Exit");		
		g_option.setName("Award Scholarship");
		h_option.setName("Generate Report Card");
		i_option.setName("Show waiting list");
		j_option.setName("Validate Files");
		k_option.setName("Shuffle");
		l_option.setName("Calculate Letter Grade");


		GUIManager listener = new GUIManager();
		a_option.addActionListener(listener);
		b_option.addActionListener(listener);
		c_option.addActionListener(listener);
		d_option.addActionListener(listener);
		e_option.addActionListener(listener);
		f_option.addActionListener(listener);
		g_option.addActionListener(listener);
		h_option.addActionListener(listener);
		i_option.addActionListener(listener);
		j_option.addActionListener(listener);
		k_option.addActionListener(listener);
		l_option.addActionListener(listener);

		
		ok.setName("OK");
		ok.addActionListener(listener);
	}

	
	//case A
	public static void caseA(){
		
		JFrame frame = new JFrame("Student List");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		frame.setSize(400, 300);
		frame.setLocation(400, 100);
		frame.setVisible(true);
		
		frame.add(new Label("Student Name:          ID:"));
		
		
		java.util.Iterator<Student> iter = student_list.iterator();		
		
		//while there are no more students in courses
		while(iter.hasNext()){
			
			//grab the first student
			Student current_student = iter.next();
			frame.add(new JLabel(current_student.getName() + "          " + current_student.getId()));
		}
		
		//frame.add(ok);
	}
	
	//case b
	public static void caseB(){
		
		//create a new frame
		JFrame frame = new JFrame("Course List");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		frame.setSize(400, 300);
		frame.setLocation(400, 100);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new JLabel("Course Name: "));
		
		java.util.Iterator<Course> iter = course_list.iterator();		
		while(iter.hasNext()){
			
			//grab the first student
			Course current_course = iter.next();
			frame.add(new JLabel(current_course.getName()));
		}
		
		//frame.add(ok);
	}
	
	//case c
	public static void caseC(){
		boolean correct_input = false;
		Course current_course = null;
		while(!correct_input){
			try{
				String course_name = JOptionPane.showInputDialog(null, "Enter the course name: ", "Add a Student", JOptionPane.INFORMATION_MESSAGE).toUpperCase();
				//check to see if the course exists
				
				java.util.Iterator<Course> iter = course_list.iterator();		
				while(iter.hasNext()){
					
					//grab the first course
					current_course = iter.next();
					if(course_name.equals(current_course.getName())){
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}
				}
				
				if(!correct_input){
					throw new CourseNotFoundException("CourseNotFoundException.");
				}
			}
			catch(CourseNotFoundException ex){
				JOptionPane.showMessageDialog(null, "Course not found", "ERROR", JOptionPane.INFORMATION_MESSAGE);

			}
			catch(IllegalArgumentException ex){
				JOptionPane.showMessageDialog(null, "Illegal Argument", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
		correct_input = false;		
		boolean course_full = false;
		Student current_student = null;
		while(!correct_input){
			if (current_course.list_students.size() > 2){
				course_full = true;
				try{
					String id = JOptionPane.showInputDialog(null, "Course is full, but enter the ID number of the student \n you would like to add to the waiting list: ", "Enter ID", JOptionPane.QUESTION_MESSAGE);
					int int_id = Integer.parseInt(id);
					
					
					java.util.Iterator<Student> iter = student_list.iterator();		
					while(iter.hasNext()){
						
						//grab the first course
						current_student = iter.next();
						if(int_id == current_student.getId()){
							correct_input = true;
							break;
						}
						else correct_input = false;
					}
									
					if (!correct_input) 
						throw new StudentNotFoundException("StudentNotFoundException.");
					
					
					current_course.waiting_list.add(current_student);
					JOptionPane.showMessageDialog(null, "Student added the waiting list", "Waiting list", JOptionPane.INFORMATION_MESSAGE);

				}
				catch(StudentNotFoundException ex){
					JOptionPane.showMessageDialog(null, "Student not found", "ERROR", JOptionPane.OK_OPTION);
				}
				catch(InputMismatchException ex){
					JOptionPane.showMessageDialog(null, "Illegal Argument", "ERROR", JOptionPane.OK_OPTION);
				}
			}else correct_input = true;		
		}//end while
		
		//input the student ID
		if (!course_full){
			correct_input = false;		
		}
		else correct_input = true;		

		
		boolean third_loop = false;
		int int_id = 0;
		while(!correct_input){
			try{
				
				String id = JOptionPane.showInputDialog(null, "Enter the ID number of the student you would like to add: ", "Enter ID", JOptionPane.QUESTION_MESSAGE);
				int_id = Integer.parseInt(id);

				java.util.Iterator<Student> iter = student_list.iterator();		
				while(iter.hasNext()){

					//grab the first course
					current_student = iter.next();
					if(int_id == current_student.getId()){
						correct_input = true;
						break;
					}
					else correct_input = false;
				}
				if (!correct_input)
					throw new StudentNotFoundException("StudentNotFoundException.");

				//check for duplicates
				if(current_course.list_students.contains(current_student))
					correct_input = false;

				//jmessage
				if(!correct_input){
					JOptionPane.showMessageDialog(null, "Student is already enrolled in the course", "ERROR", JOptionPane.OK_OPTION);
					third_loop = false;
				}
				else third_loop = true;		
				
				//add the current student to the list of students that are in courses (if he/she is not in the course already
				if(!students_in_courses.contains(current_student)){
					students_in_courses.add(current_student);
				}
				
				
				if(third_loop){
					//add the student to the course
					current_course.list_students.add(current_student);
					JOptionPane.showMessageDialog(null, "Student Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//add the current course to the student's list of courses
				current_student.courses.add(current_course);
				
				//add the course to the students course array
				Integer[] array = {1 + (int)(Math.random() * 99), 1 + (int)(Math.random() * 99), 1 + (int)(Math.random() * 99), 1 + (int)(Math.random() * 99)};

				current_student.grades.add(array);
				current_student.setAverage();


			}
			catch(StudentNotFoundException ex){
				JOptionPane.showMessageDialog(null, "Student not found", "ERROR", JOptionPane.OK_OPTION);

			}catch(InputMismatchException ex){
				JOptionPane.showMessageDialog(null, "Illegal Argument", "ERROR", JOptionPane.OK_OPTION);
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Illegal Argument", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		}//end while
	}
	
	//case d
	public static void caseD(){
		boolean correct_input = false;
		Course current_course = null;
		while(!correct_input){
			try{
				//enter the course name and validate the input
				String course_name = JOptionPane.showInputDialog(null, "Enter the course name: ", "Remove a Student", JOptionPane.QUESTION_MESSAGE).toUpperCase();

				//check to see if the course exists
				java.util.Iterator<Course> iter = course_list.iterator();		
				while(iter.hasNext()){
					
					//grab the first course
					current_course = iter.next();
					if(course_name.equals(current_course.getName())){
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}
				}
				
				if(!correct_input){
					throw new CourseNotFoundException("CourseNotFoundException.");
				}
				
				if (current_course.list_students.isEmpty()){
					System.out.println("Course is empty!\n\n");
					correct_input = false;
				}
				
				if(!correct_input){
					JOptionPane.showMessageDialog(null, "Course is empty!", "ERROR", JOptionPane.OK_OPTION);
				}

			}
			catch(CourseNotFoundException ex){
				System.out.println("The course name you entered is invalid. \n");
				JOptionPane.showMessageDialog(null, "Course not found", "ERROR", JOptionPane.OK_OPTION);
			}
		}
		correct_input = false;
		
		Student current_student = null;
		while(!correct_input){
			try{
				
				//get the user ID
				//input the student ID
				String str_id = JOptionPane.showInputDialog(null, "Enter the ID number of the student you would like to remove: ", "Remove a Student", JOptionPane.QUESTION_MESSAGE).toUpperCase();
				int int_id = Integer.parseInt(str_id);
				
				//find the student by matching the ID
				java.util.Iterator<Student> iter = student_list.iterator();		
				while(iter.hasNext()){

					//grab the first course
					current_student = iter.next();
					if(int_id == current_student.getId()){
						correct_input = true;
						break;
					}
					else correct_input = false;
				}
				if (!correct_input)
					throw new StudentNotFoundException("StudentNotFoundException.");
				
			}
			catch(StudentNotFoundException ex){
				System.out.println("Student not found. \n");
				JOptionPane.showMessageDialog(null, "Student not found", "ERROR", JOptionPane.OK_OPTION);
			}
		}
		
		correct_input = false;
		while(!correct_input){
			try{
				
				java.util.Iterator<Student> iter = current_course.list_students.iterator();		
				while(iter.hasNext()){

					//grab the first student
					Student tmp_student = iter.next();
					if(current_student.getId() == tmp_student.getId()){
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
						throw new StudentNotFoundException("StudentNotFoundException");
					}
				}
			}
			catch(StudentNotFoundException ex){
				System.out.println("The student name you entered is invalid. \n");
				JOptionPane.showMessageDialog(null, "Student not found", "ERROR", JOptionPane.OK_OPTION);
			}
		}
		
		current_course.list_students.remove(current_student);

		//remove student
		System.out.println("Student removed successfully\n");
		JOptionPane.showMessageDialog(null, "Student removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

		Student student_added = null;
		//add any one is on the waiting list
		if (!current_course.waiting_list.isEmpty()){
			student_added = current_course.waiting_list.remove();
			student_added.courses.add(current_course);
			JOptionPane.showMessageDialog(null, "Student in waiting list added to the course.", "Success", JOptionPane.INFORMATION_MESSAGE);
			current_course.list_students.add(student_added);
			
			
			//give the student grades..
			Integer[] array = {1 + (int)(Math.random() * 99), 1 + (int)(Math.random() * 99),1 + (int)(Math.random() * 99),1 + (int)(Math.random() * 99)};
			student_added.grades.add(array);
			student_added.setAverage();
		}

		//Add the current student to the lists of students in a course (if he/she is not on there already
		if(!students_in_courses.contains(student_added)){
			students_in_courses.add(student_added);
		}		
	}

	
	//case e
	public static void caseE() throws IOException{

		boolean correct_input = false;
		Course current_course = null;
		while(!correct_input){
			try{
				//enter the course name and validate the input
				String course_name = JOptionPane.showInputDialog(null, "Enter the course name: ", "View Class", JOptionPane.QUESTION_MESSAGE).toUpperCase();

				//check to see if the course exists
				java.util.Iterator<Course> iter = course_list.iterator();		
				while(iter.hasNext()){

					//grab the first course
					current_course = iter.next();
					if(course_name.equals(current_course.getName())){
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}	
				}

				//return to main menu if input is not correct
				if (!correct_input){
					throw new CourseNotFoundException("CourseNotFoundException.");
				}
			}catch(CourseNotFoundException ex){
				System.out.println("The course name you entered is invalid. \n");
				JOptionPane.showMessageDialog(null, "Course not found", "ERROR", JOptionPane.OK_OPTION);

			}
		}
		
		correct_input = false;
		int screen_file = 0;
		while(!correct_input){
			try{
				String the_screen_file = JOptionPane.showInputDialog(null, "ENTER 1 - OUTPUT to SCREEN; ENTER 2 - SAVE to FILE ", "View Class", JOptionPane.QUESTION_MESSAGE).toUpperCase();
				screen_file = Integer.parseInt(the_screen_file);

				if(screen_file == 1){

					//create a new frame
					JFrame course_display_frame = new JFrame("Course List");
					course_display_frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
					course_display_frame.setSize(400, 300);
					course_display_frame.setLocation(400, 100);
					course_display_frame.setVisible(true);

					course_display_frame.add(new JLabel("Class List for " + current_course.getName()));
					course_display_frame.add(new JLabel("Number of students in the course = " + current_course.list_students.size()));
					course_display_frame.add(new JLabel("Student Name,  ID"));


					java.util.Iterator<Student> iter = current_course.list_students.iterator();		
					while(iter.hasNext()){

						//grab the first course
						Student tmp_student = iter.next();
						course_display_frame.add(new JLabel(tmp_student.getName() + " " + tmp_student.getId()));
					}
					
					correct_input = true;

				}
				else if (screen_file == 2){

					//write to the text file
					BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\iris\\workspace\\amichaan_lab03\\" + current_course.getName() + ".txt"));
					out.write("Class List for " + current_course.getName());
					out.newLine();
					out.write("Number of students in the course = " + current_course.list_students.size());
					out.newLine();
					out.write("Class List ");
					out.newLine();
					out.newLine();
					out.write("Student		Name ID\n");
					out.newLine();
					
					java.util.Iterator<Student> iter = current_course.list_students.iterator();		
					while(iter.hasNext()){

						//grab the first course
						Student tmp_student = iter.next();
						out.write(tmp_student.getName() + "		" + tmp_student.getId());
						out.newLine();
					}
				}
				else{
					System.out.println("incorrect input");
					correct_input = false;

				}
			}catch(InputMismatchException ex){
				System.out.println("InputMismatchException.");
				System.out.println("You must enter 1 OR 2. \n");
				JOptionPane.showMessageDialog(null, "Must enter 1 or 2", "ERROR", JOptionPane.OK_OPTION);		
			}
		}

	}

	
	//case f
	public static void caseF(){
		JOptionPane.showMessageDialog(null, "Exiting Program", "Exit", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	//case g
	public static void caseG(){
		
		//we have a double  with the highest average
		//need to iterate through the list of students and find the one who has that average.
		boolean correct_input = false;
		while(!correct_input){

			if(students_in_courses.size() == 0){
				correct_input = true;
				JOptionPane.showMessageDialog(null, "No students have been registered", "Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			                                    
			//enter the course name and validate the input
			String one_or_two = JOptionPane.showInputDialog(null, "Enter 1 - For Best Student Award. Enter 2 - For Highest Mark Award  ", "Scholarships", JOptionPane.QUESTION_MESSAGE).toUpperCase();

			//best average (student)
			if (Integer.parseInt(one_or_two) == 1){
				correct_input = true;
				BestStudentAward best = new BestStudentAward();
				double mark = best.getWinner(students_in_courses);
				
				//create an interator for students currently in courses
				//we want to check to see which student has the best average
				java.util.Iterator<Student> iter = students_in_courses.iterator();		
				
				//create a reference to the student with the best average
				Student top_student = null;
				
				//while there are no more students in courses
				while(iter.hasNext()){
					
					//grab the first student
					Student current_student = iter.next();
				
					//get the student with the best average
					if (current_student.average == mark) top_student = current_student;
				
				}
				
				JOptionPane.showMessageDialog(null, "The winner of the Best Student Award is " + top_student.getName() + " with an average of " + top_student.average + ".", "Highest Average", JOptionPane.INFORMATION_MESSAGE);
			}
			//highest mark in a course
			else if (Integer.parseInt(one_or_two) == 2){
				correct_input = true;
				
				HighestMarkAward best = new HighestMarkAward();
				double highest_mark = best.getWinner(students_in_courses);
				
				//create an interator for students currently in courses
				//we want to check to see which student has the best average
				java.util.Iterator<Student> iter = students_in_courses.iterator();		
				
				//create a reference to the student with the best average
				Student top_student = null;
				
				//while there are no more students in courses
				while(iter.hasNext()){
					
					//grab the first student
					Student current_student = iter.next();
				
					//find who the top student is
					if(current_student.highestMark() == highest_mark) top_student = current_student;
				}
				
				JOptionPane.showMessageDialog(null, "The winner of the Best Student Award is " + top_student.getName() + " with a Highest mark of " + top_student.highestMark() + ".", "Highest Mark", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				correct_input = false;
				JOptionPane.showMessageDialog(null, "Invalid entry!", "ERROR", JOptionPane.OK_OPTION);
			}
		}
	}

	
	//case h
	public static void caseH(){
		JFrame course_display_frame = new JFrame("Report Card");
		course_display_frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		course_display_frame.setSize(400, 300);
		course_display_frame.setLocation(400, 100);
		course_display_frame.setVisible(true);
		course_display_frame.add(new JLabel("Report Card:"));
		
		java.util.Iterator<Student> iter = students_in_courses.iterator();		
		
		//while there are no more students in courses
		while(iter.hasNext()){
			
			//grab the first student
			Student current_student = iter.next();
			
			//grab the next course, and the corresponding grades
			java.util.Iterator<Course> student_course_iter = current_student.courses.iterator();
			java.util.Iterator<Integer[]> student_grade_iter = current_student.grades.iterator();
			String display = new String();
			
			//iterate through a student's course list
			int i = 0;
			while(student_course_iter.hasNext()){
				Course current_course = student_course_iter.next();
				Integer [] the_grades = student_grade_iter.next();
				
				//get the course names and the corresponding grades and add it to a string
				//if the student has zero courses
				if (i == 0){
					display = current_student.getName() + ": " + current_course.getName() +": "+ the_grades[0] + "," + the_grades[1] + "," + the_grades[2] + "," + the_grades[3];
				}
				//if the student has one course
				else  display =  current_course.getName() +": "+ the_grades[0] + "," + the_grades[1] + "," + the_grades[2] + "," + the_grades[3];
				course_display_frame.add(new JLabel(display));
				i++;
			}
		}
	}
	
	//case i
 	public static void casei(){

	
		
		boolean correct_input = false;
		int course_index = 0;
		Course current_course = null;
		while(!correct_input){
			try{
				String course_name = JOptionPane.showInputDialog(null, "Enter the course name of the waiting that you want to see: ", "Waiting List", JOptionPane.INFORMATION_MESSAGE).toUpperCase();
				//check to see if the course exists
				
				
				java.util.Iterator<Course> iter = course_list.iterator();		
				while(iter.hasNext()){
					
					//grab the first course
					current_course = iter.next();
					if(course_name.equals(current_course.getName())){
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}
				}
				//if the input is not valid go back to the main menu
				if(!correct_input){
					throw new CourseNotFoundException("CourseNotFoundException.");
				}
			}
			catch(CourseNotFoundException ex){
				JOptionPane.showMessageDialog(null, "Course not found", "ERROR", JOptionPane.INFORMATION_MESSAGE);

			}
			catch(IllegalArgumentException ex){
				JOptionPane.showMessageDialog(null, "Illegal Argument", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		JFrame frame = new JFrame("Waiting List");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		frame.setSize(400, 300);
		frame.setLocation(400, 100);
		frame.setVisible(true);
		frame.add(new JLabel("Waiting List for " + current_course.getName() + ":"));	
		
		java.util.Iterator<Student> iter =  current_course.waiting_list.iterator();
		while(iter.hasNext()){
			Student student = iter.next();
			frame.add(new JLabel(student.getName() + "    " + student.getId()));	
		}
	}
	
	public static void caseJ(){

		JFrame keyword_frame = new JFrame("Keyword");
		keyword_frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		keyword_frame.setLocation(400, 100);
		keyword_frame.setSize(400, 300);
		keyword_frame.setVisible(true);
		
		Keyword keyword = new Keyword();
		TreeMap	<String,Integer> map = keyword.noDuplicates();
		
		Set<String> x = map.keySet();
		for(Object p: x){
			keyword_frame.add(new JLabel(p.toString() + ": " + map.get(p)));
		}
	}

	public static void caseK(){
		Shuffle shuf = new Shuffle();	
		shuf.setList(student_list, course_list);
		shuf.setVisible(true);
	}
 	
	public void actionPerformed(ActionEvent e){
		
		//string which indicates the button has been pressed
		String match_string = new String(e.getActionCommand());
		
		//depending on the button that has been pressed call its function
		if(match_string.equals(a_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseA();
		}
		else if(match_string.equals(b_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseB();
		}
		else if(match_string.equals(c_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseC();
		}
		else if(match_string.equals(d_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseD();
		}
		else if(match_string.equals(e_option.getName())){
			System.out.println("The " + e.getActionCommand());
			try {
				caseE();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(match_string.equals(f_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseF();		
		} 
		else if(match_string.equals(ok.getName())){
			System.out.println("The " + e.getActionCommand());
		}
		else if(match_string.equals(g_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseG();
		}
		else if(match_string.equals(h_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseH();
		}
		else if(match_string.equals(i_option.getName())){
			System.out.println("The " + e.getActionCommand());
			casei();
		}
		else if(match_string.equals(j_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseJ();
		}
		else if(match_string.equals(k_option.getName())){
			System.out.println("The " + e.getActionCommand());
			caseK();
		}
		else System.out.println("you hit the else statement you should check out wahts wrong!");
	}
	
	
	public static void main(String[] args) throws StudentNotFoundException, CourseNotFoundException, IOException{
		
		course_list = d1.initCourses();
		d1.setCourseArray(course_list);
		student_list = d1.initStudents();
		d1.setStudentArray(student_list);
		displayMenu();
		
	}

	
	 
	

}
