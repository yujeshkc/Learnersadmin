package learnersadmin.model;


import java.util.List;

import javax.persistence.CascadeType;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "classes")
@Table(name = "classes")
public class ClassesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, name="name")
	private String className;
	
	@Column(nullable=true, name="number")
	private String classNumber;	
		
	@Column(nullable=false, name="shift")
	private String classShift;
	
	//private Set<StudentModel> student;
	
	@OneToMany(targetEntity = StudentModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
    private List<StudentModel> student;
	
	@OneToMany(targetEntity = SubjectModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
    private List<StudentModel> subject;
	
	
	public ClassesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassesModel(int id) {
		super();
		this.id = id;
	}

	public ClassesModel(int id, String className, String classNumber, String classShift) {
		super();
		this.id = id;
		this.className = className;
		this.classNumber = classNumber;
		this.classShift = classShift;
	}


	public ClassesModel(String className, String classNumber, String classShift) {
		super();
		this.className = className;
		this.classNumber = classNumber;
		this.classShift = classShift;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getClassNumber() {
		return classNumber;
	}


	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}


	public String getClassShift() {
		return classShift;
	}


	public void setClassShift(String classShift) {
		this.classShift = classShift;
	}

	public List<StudentModel> getStudent() {
		return student;
	}

	public void setStudent(List<StudentModel> student) {
		this.student = student;
	}

	public List<StudentModel> getSubject() {
		return subject;
	}

	public void setSubject(List<StudentModel> subject) {
		this.subject = subject;
	}
	

	
	
	
}
