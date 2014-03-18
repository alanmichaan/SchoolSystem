package amichaan_lab02;

public class Student {
	public String m_name;
	public int m_id;
	
	
	//constructor that takes two parameters
	Student(String name, int id) {
		this.m_name = name;
		this.m_id = id;
	}

	public String getName() {
		return m_name;
	}
	
	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int m_id) {
		this.m_id = m_id;
	}

	
	
}
