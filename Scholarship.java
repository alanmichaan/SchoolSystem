package amichaan_lab03;

import java.util.Vector;

public abstract class Scholarship {
	private String name;
	private int value;
	private String winner;
	
	Scholarship(){};
	
	Scholarship(String aname, int avalue, String awinner){
		this.name = aname;
		this.value = avalue;
		this.winner = awinner;
	}
	
	abstract double getWinner(Vector<Student> students_in_courses);
	
	public String toString(){
		return name + value + winner;
	}
}
