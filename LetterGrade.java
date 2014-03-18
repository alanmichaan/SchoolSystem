package studentsystem;

import javax.swing.*; 
import javax.swing.border.TitledBorder; 
import java.awt.*; 
import java.awt.event.*; 

public class LetterGrade extends JFrame {

	private JLabel ES1036 = new JLabel("ES1036"); 
	private JLabel CS1037 = new JLabel("CS1037"); 
	private JLabel SE2205 = new JLabel("SE2205"); 
	private JLabel SE2250 = new JLabel("SE2250"); 
	private JLabel total_marks = new JLabel("Total Marks"); 
	private JLabel average_marks = new JLabel("Average Marks"); 
	private JLabel letter_grade = new JLabel("Letter Grade"); 

	
	private JTextField ES1036Mark = new JTextField(); 
	private JTextField CS1037Mark = new JTextField(); 
	private JTextField SE2205Mark = new JTextField(); 
	private JTextField SE2250Mark = new JTextField(); 
	private JTextField total = new JTextField(); 
	private JTextField average = new JTextField(); 
	private JTextField grade = new JTextField(); 

	
//	private JTextField jtfTotalPayment = new JTextField(); 

	private JButton computeLoan = new JButton("Calculate Grade"); 

	LetterGrade() { 
		JPanel panel = new JPanel(new GridLayout(8,2)); 
		panel.add(ES1036); 
		panel.add(ES1036Mark); 
		
		panel.add(CS1037); 
		panel.add(CS1037Mark); 
		
		panel.add(SE2205); 
		panel.add(SE2205Mark); 
		
		panel.add(SE2250); 
		panel.add(SE2250Mark); 
		
		panel.add(total_marks);
		panel.add(total);

		panel.add(average_marks); 
		panel.add(average);
		
		panel.add(letter_grade); 
		panel.add(grade); 
		

		panel.setBorder(new TitledBorder("Enter Marks for four subjects:")); 
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		panel3.add(computeLoan); 
		add(panel, BorderLayout.CENTER); 
		add(panel3, BorderLayout.SOUTH); 
		computeLoan.addActionListener(new ActionListener() { 


			public void actionPerformed(ActionEvent e) { 
				//get values from text fields 
				double mark_1036 = Double.parseDouble(ES1036Mark.getText()); 
				double mark_1037 = Double.parseDouble(CS1037Mark.getText()); 
				double mark_2205 = Double.parseDouble(SE2205Mark.getText()); 
				double mark_2250 = Double.parseDouble(SE2250Mark.getText()); 

				double total_marks = mark_1036 + mark_1037 + mark_2205 + mark_2250;
				double avg = total_marks/4;
				total.setText(String.format("%.2f", total_marks)); 
				average.setText(String.format("%.2f", avg)); 
				
				LGrade grd = new LGrade();
				grade.setText(grd.getMark(avg)); 
			} 
		}); 
	} 

	public static void main(String[] args) { 
		LetterGrade frame = new LetterGrade(); 
		frame.pack(); 
		frame.setTitle("Letter Grade"); 
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true); 
	}

}



class LGrade { 
	/** Default constructor */ 
	
	public LGrade() { 
		
	} 
	
	public String getMark(double average){
		if(average < 50){
			return "F";
		}
		else if (average>= 50 && average <75){
			return "C+";
		}
		else return "A";
		
		
		
	}
	
}
	


	

