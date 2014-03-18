package studentsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Shuffle extends JFrame{
	private static final long serialVersionUID = 1L;
	private Queue<Student>	student_list =	new	LinkedList<Student>();	
	private Queue<Course>	course_list	=	new	LinkedList<Course>();	

	private JTextField	jtfNumber	=	new	JTextField(8);	
	private	JTextArea	jtaNumbers	=	new	JTextArea();	
	private	JButton	jbtSort	=	new	JButton("Sort");	
	private JButton	jbtShuffle	=	new	JButton("Shuffle");	
	private JButton	jbtReverse	=	new	JButton("Reverse");	

	public Shuffle(){
		JPanel	panel1 = new JPanel();	
		panel1.add(new JLabel("Enter a number:	"));	
		panel1.add(jtfNumber);	
		JScrollPane	jsp	= new JScrollPane(jtaNumbers);	
		JPanel	panel2 = new JPanel();	
		panel2.add(jbtSort);	
		panel2.add(jbtShuffle);	
		panel2.add(jbtReverse);	
		this.add(panel1,BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);	
		add(panel2, BorderLayout.SOUTH);	
		this.setSize(400, 400);

		

		jbtSort.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				String choice = jtfNumber.getText().toUpperCase();
				Course current_course = null;
				if(choice.equals("ALL")){
					System.out.println("here");
					Collections.sort((LinkedList<Student>) student_list);
					String result = "";
					for(Student x: student_list){
						result+=x.getName() + " " + x.getAverage()+ "\n";
					}
					jtaNumbers.setText(result);
					jtaNumbers.setVisible(true);
					System.out.println("hi");
				}
				else {
					for(Course x: course_list){
						if(x.getName().equals(choice)){
							System.out.println(x.getName());
							current_course = x;
						}
					}
					if(current_course != null){
						String result = "";
						for(Student x: current_course.list_students){
							result+=x.getName() + " " + x.getAverage()+ "\n";
						}
						jtaNumbers.setText(result);
						jtaNumbers.setVisible(true);
					}
				}
			} 
		}); 

		jbtShuffle.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				System.out.println("apple");

				String choice = jtfNumber.getText().toUpperCase();
				Course current_course = null;
				if(choice.equals("ALL")){
					System.out.println("here");
					Collections.shuffle((LinkedList<Student>) student_list);
					String result = "";
					for(Student x: student_list){
						result+=x.getName() + " " + x.getAverage()+ "\n";
					}
					jtaNumbers.setText(result);
					jtaNumbers.setVisible(true);
				}
				else {
					for(Course x: course_list){
						if(x.getName().equals(choice)){
							System.out.println(x.getName());
							current_course = x;
						}
					}
					if(current_course != null){
						String result = "";
						for(Student x: current_course.list_students){
							result+=x.getName() + " " + x.getAverage()+ "\n";
						}
						jtaNumbers.setText(result);
						jtaNumbers.setVisible(true);
					}
				}
				
			} 
		}); 

		jbtReverse.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				//Collections.reverse(list);
				String choice = jtfNumber.getText().toUpperCase();
				Course current_course = null;
				if(choice.equals("ALL")){
					System.out.println("here");
					Collections.reverse((LinkedList<Student>) student_list);
					String result = "";
					for(Student x: student_list){
						result+=x.getName() + " " + x.getAverage()+ "\n";
					}
					jtaNumbers.setText(result);
					jtaNumbers.setVisible(true);
					System.out.println("hi");
				}
				else {
					for(Course x: course_list){
						if(x.getName().equals(choice)){
							System.out.println(x.getName());
							current_course = x;
						}
					}
					if(current_course != null){
						//System.out.println(current_course.list_students);
						//System.out.println("apple");
						String result = "";
						for(Student x: current_course.list_students){
							result+=x.getName() + " " + x.getAverage()+ "\n";
						}
						jtaNumbers.setText(result);
						jtaNumbers.setVisible(true);
						//System.out.println("hi");
					}
				}		
			} 
		});
	}
	
	public void setList(Queue<Student> student_list, Queue<Course> course_list){
		this.student_list = student_list;
		this.course_list = course_list;
	}
	
	
	
}
