package learnersadmin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="subjects")
@Table(name="subjects")
public class SubjectModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, nullable=false, length= 150)
	private String  subject;
	

	@Column(nullable=false, length=8, name="subjectTime")
    private String subjectTime;

	@ManyToOne(targetEntity = ClassesModel.class)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassesModel classes;
	
	@ManyToOne(targetEntity = TeacherModel.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherModel teacher;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getSubjectTime() {
		return subjectTime;
	}


	public void setSubjectTime(String subjectTime) {
		this.subjectTime = subjectTime;
	}


	public ClassesModel getClasses() {
		return classes;
	}


	public void setClasses(ClassesModel classes) {
		this.classes = classes;
	}

	public TeacherModel getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}

	
	@Override
	public String toString() {
		return "SubjectModel [id=" + id + ", subject=" + subject + " time =" + subjectTime + ", ]";
	}
	
	
	
	
}
