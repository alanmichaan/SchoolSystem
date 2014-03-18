package amichaan_lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Student larry = new Student("Larry", 1111);
		Student jill = new Student("Jill", 2222);
		Student john = new Student("John", 3333);
		Student mike = new Student("Mike", 4444);
		Student sarah = new Student("Sarah", 5555);
		Student dan = new Student("Dan", 6666);
		Student julia = new Student("Julia", 7777);
		Student bradley = new Student("Bradley", 8888);
		Student rita = new Student("Rita", 9999);
		Student bill = new Student("Bill", 1010);
		Student[] student_array = new Student[10];
		
		//add the students to the array
		student_array[0] = larry;
		student_array[1] = jill;
		student_array[2] = john;
		student_array[3] = mike;
		student_array[4] = sarah;
		student_array[5] = dan;
		student_array[6] = julia;
		student_array[7] = bradley;
		student_array[8] = rita;
		student_array[9] = bill;

		/*for (int i = 0; i < 9; i++){
			System.out.println(student_array[i].getId());
		}*/
		
		//create the courses
		Course am1413 = new Course("AM1413");
		Course es1050 = new Course("ES1050");
		Course am1411 = new Course("AM1411");
		Course es1021 = new Course("ES1021");
		Course es1036 = new Course("ES1036");
		
		//add the courses to the course array
		Course[] course_array = new Course[5];
		course_array[0] = am1413;
		course_array[1] = es1050;
		course_array[2] = am1411;
		course_array[3] = es1021;
		course_array[4] = es1036;
		
		//add a new department
		Department department = new Department(student_array,course_array);
	
		boolean correct_input = false;
		while(!correct_input){
			displayMenu();
			
			//take an input from the user
			Scanner sc1 = new Scanner(System.in);
			String input = sc1.next().toUpperCase();
			switch(input) {
			case "A": { //print out all the student names
				System.out.println("NAME:		ID:\n");
				System.out.println(larry.getName() + "		" + larry.getId());
				System.out.println(jill.getName()+ "		" + jill.getId());
				System.out.println(john.getName()+ "		" + john.getId());
				System.out.println(mike.getName()+ "		" + mike.getId());
				System.out.println(sarah.getName()+ "		" + sarah.getId());
				System.out.println(dan.getName()+ "		" + dan.getId());
				System.out.println(julia.getName()+ "		" + julia.getId());
				System.out.println(bradley.getName()+ "		" + bradley.getId());
				System.out.println(rita.getName()+ "		" + rita.getId());
				System.out.println(bill.getName()+ "		" + bill.getId() + "\n\n");
				
				//go back to the main menu
				correct_input = false;
				break;
			}
			case "B": { //print out the course names
				System.out.println(am1413.getName());
				System.out.println(es1050.getName());
				System.out.println(am1411.getName());
				System.out.println(es1021.getName());
				System.out.println(es1036.getName()+ "\n\n");
				
				//go back to the main menu
				correct_input = false;
				break;
			}
			case "C": {

				//input the course name
				System.out.println("Enter the course name: ");
				String course_name = sc1.next();
				int course_index = 0;
				//check to see if the course exists
				for(int i = 0; i< course_array.length; i++){
					if (course_name.equals(course_array[i].getName())){
						//System.out.println("course exists");
						correct_input = true;
						course_index = i;
						break;
					}
					else{
						correct_input = false;
					}
				}
				//if the input is not valid go back to the main menu
				if(!correct_input) break;
				
				//check to see if the course is full
				if (course_array[course_index].isFull()){
					System.out.println("Do you wish to increase the class capacity?(yes/no)): ");
					String yes_no = sc1.next();
					
					//if the course if full increase the size of the list or not....
					if (yes_no.equals("yes")){
						System.out.println("How big would you like to make the class? (greater than 5)");
						int new_size = sc1.nextInt();
						Student[] new_size_array = new Student[new_size];
						
						//copy the list of students from the chosen course onto a new list
						for (int i = 0; i< course_array[course_index].list_students.length; i++){
							new_size_array[i] = course_array[course_index].list_students[i];
						}
						
						//set the student list of a particular course to the new list
						course_array[course_index].list_students = new_size_array;
						System.out.println("Size of the class has been changed to " + new_size+ " students." );
						correct_input = true;
					}
					else if (yes_no.equals("no")){
						System.out.println("Course is full. Sorry.");
						correct_input = false;
					}
					else correct_input = false;
				}
				//else course is not full add the student to the course
				else correct_input = true;
				
				//if the input isnt validated go back to the main menu
				if(!correct_input) break;				

				//input the student ID
				System.out.println("Enter the ID number of the student you would like to add: ");
				String id = sc1.next();
				int int_id = Integer.parseInt(id);
				//System.out.println(int_id);

				
				//find the student by matching the ID
				int student_index= 0;
				for (int i = 0; i< student_array.length; i++){
					if (student_array[i].getId() == int_id){
						student_index = i;
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}
				}	
				//if the input isnt validated go back to the main menu
				if(!correct_input){
					System.out.println("invalid ID.");
					System.out.println("Student not added.\n");
					break;	
				}
				
				//if the program gets to this point all the inputs have been validated
				//add the student to the course
				course_array[course_index].list_students[course_array[course_index].size()] = student_array[student_index];
				System.out.println("Student added!\n");
				
				//go back to the main menu
				correct_input = false;
				break;
			}
			case "D": {
				
				//enter the course name and validate the input
				System.out.println("Enter the course name: ");
				String course_name = sc1.next();
				int course_index = 0;
				//check to see if the course exists
				for(int i = 0; i< course_array.length; i++){
					if (course_name.equals(course_array[i].getName())){
						//System.out.println("course exists");
						correct_input = true;
						course_index = i;
						break;
					}
					else correct_input = false;
			
					
				}
				
				//return to main menu if input is not correct
				if (!correct_input){
					System.out.println("Course doesnt exist. \n");
					break;
				}
				
				//check if the course is empty
				if (course_array[course_index].size() == 0){
					System.out.println("Course is empty!\n\n");
					correct_input = false;
				}
				if (!correct_input) break;
				
				//get the user ID
				//input the student ID
				System.out.println("Enter the ID number of the student you would like to remove: ");
				String id = sc1.next();
				int int_id = Integer.parseInt(id);

				
				//find the student by matching the ID
				int student_index= 0;
				for (int i = 0; i< student_array.length; i++){
					int idd = student_array[i].getId();
					if (idd == int_id){
						student_index = i;
						correct_input = true;
						break;
					}
					else{
						correct_input = false;
					}
				}
				if (!correct_input){
					System.out.println("Student does not exist!");
					break;
				}
				
				//check if the student is in the course
				int student_course_index= 0;
				for(int i = 0; i < course_array[course_index].size(); i++){
					if (course_array[course_index].list_students[i].getId() == student_array[student_index].getId()){
						correct_input = true;
						student_course_index = i;
						//System.out.println("student is in the course");
						break;
					}
					else correct_input = false;
					
				}
				if (!correct_input){
					System.out.println("Student is not in the course!");
					break;
				}
				System.out.println("Student removed successfully\n");
				
				//transfer array
				int initial_size = course_array[course_index].size();
				for (int i = student_course_index; i < initial_size-1; i++){
					course_array[course_index].list_students[i] = course_array[course_index].list_students[i+1];
				}
				course_array[course_index].list_students[initial_size-1]= null;
				
				/*for(int i = 0; i < course_array[course_index].size(); i++){
					if (course_array[course_index].list_students[i] != null){
						System.out.println(course_array[course_index].list_students[i].getName());
					}
					else System.out.println("null");
				}*/
				
				correct_input = false;
				break;
			}
			case "E": {
				
				//enter the course name and validate the input
				System.out.println("Enter the course name: ");
				String course_name = sc1.next();
				int course_index = 0;
				//check to see if the course exists
				for(int i = 0; i< course_array.length; i++){
					if (course_name.equals(course_array[i].getName())){
						//System.out.println("course exists");
						correct_input = true;
						course_index = i;
						break;
					}
					else{
						correct_input = false;
					}
				}
				
				//return to main menu if input is not correct
				if (!correct_input) break;
				
				//check if the course is empty
				if (course_array[course_index].size() == 0){
					System.out.println("Course is empty!\n\n");
					correct_input = false;
				}
				if (!correct_input) break;
				
				
				System.out.println("Class List for " + course_array[course_index].getName());
				System.out.println("Number of students in the course = " + course_array[course_index].size());
				System.out.println("Class List ");
				System.out.println("Student		Name ID\n");
				for(int i = 0; i < course_array[course_index].size(); i++){
					System.out.println(course_array[course_index].list_students[i].getName() + "		" + course_array[course_index].list_students[i].getId());
				}
				
				System.out.println();
				correct_input = false;
				break;
			}
			case "F": {
				correct_input = true;
				System.out.println("Goodbye!\n");
				break;
			}
			default: {
				correct_input = false;
			}
			}
		}
	}
	
	public static void displayMenu(){
		//display options
		System.out.println("A. Print List of All Students. ");
		System.out.println("B. Print List of Courses. ");
		System.out.println("C. Add a Student to a Course. ");
		System.out.println("D. Drop a Student From a Course. ");
		System.out.println("E. Print a List of Students in a Course. ");
		System.out.println("F. Exit. " + "\n");
		System.out.println("	Please Enter Your Choice: ");
	}
	
	
	

	
}
