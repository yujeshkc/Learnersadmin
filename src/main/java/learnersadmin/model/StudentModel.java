package learnersadmin.model;


import javax.persistence.CascadeType;
//import java.util.LinkedHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name="student")
@Entity(name="student")
public class StudentModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable=false, name="fullName")
	private String fullName;
	
	@Column(nullable=true, name="age")
	private int age;
	
	@Column(unique=true, nullable=false, length= 150, name="email")
	private String email;	
	
    @ManyToOne(targetEntity = ClassesModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassesModel classes;
    
	public StudentModel() {
		super();
	}
	
	public StudentModel(int id) {
		super();
		this.id = id;
	}
	
	//private LinkedHashMap<String, String> classOption;
	
	public StudentModel(int id, String fullName, int age, String email, ClassesModel classes) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.classes = classes;
	}

	

	public StudentModel(String fullName, int age, String email, ClassesModel classes) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.classes = classes;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClassesModel getClasses() {
		return classes;
	}


	public void setClasses(ClassesModel classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", fullName=" + fullName + ", age=" + age + ", email=" + email + ", classes=" + classes + "]";
	}	
	
}
